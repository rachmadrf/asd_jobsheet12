package asd_jobsheet12;

public class DoubleLinkedList21 {
    Node21 head;
    Node21 tail;

    public DoubleLinkedList21() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa21 data) {
        Node21 newNode = new Node21(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa21 data) {
        Node21 newNode = new Node21(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa21 data) {
        Node21 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node21 newNode = new Node21(data);

        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void add(int index, Mahasiswa21 data) {
        if (index < 0) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node21 current = head;
        int i = 0;
        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Index melebihi jumlah data.");
        } else if (current == tail) {
            addLast(data);
        } else {
            Node21 newNode = new Node21(data);
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            System.out.println("Data berhasil ditambahkan pada index ke-" + index);
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }

        Node21 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }
        System.out.print("Data yang terhapus: ");
        head.data.tampil();

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Data sudah berhasil dihapus.");
        }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }
        System.out.print("Data yang terhapus: ");
        tail.data.tampil();

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("Data sudah berhasil dihapus.");
    }

    public void removeAfter(String keyNim) {
        Node21 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Tidak ada node setelah NIM " + keyNim + " atau NIM tidak ditemukan.");
            return;
        }

        Node21 toDelete = current.next;
        System.out.print("Data yang dihapus setelah " + keyNim + ": ");
        toDelete.data.tampil();

        if (toDelete == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = toDelete.next;
            toDelete.next.prev = current;
        }

        System.out.println("Data berhasil dihapus setelah NIM " + keyNim);
    }

    public void remove(int index) {
        if (index < 0 || isEmpty()) {
            System.out.println("Index tidak valid atau list kosong.");
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node21 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Index melebihi jumlah data.");
            return;
        }

        System.out.print("Data yang dihapus: ");
        current.data.tampil();

        if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Data pada index ke-" + index + " berhasil dihapus.");
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.print("Data pertama: ");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.print("Data terakhir: ");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (index < 0 || isEmpty()) {
            System.out.println("Index tidak valid atau list kosong.");
            return;
        }

        Node21 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Index melebihi jumlah data.");
        } else {
            System.out.print("Data pada index ke-" + index + ": ");
            current.data.tampil();
        }
    }

    public int size() {
        int count = 0;
        Node21 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Node21 search(String nim) {
        Node21 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}