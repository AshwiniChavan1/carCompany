package com.core.vehicles;


public class LinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    static class Node<T>{
        T data; 
        Node<T> next;
        Node<T> prev;

        Node(T data){
            this.data = data;
        }
        Node(){

        }

    }


    public LinkedList(){

    }

    @SafeVarargs
    public LinkedList(T ...data){

        for(T d: data){
            add(d);
        }
    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {
        if(head==null)
            return true;
        return false;
    }

    public boolean add(T e) {
        return add(size, e);         
    }

    public T remove() {
        return remove(size-1);
    }

    public void clear() {
        head= null;
        tail = null;
        size = 0;
        
    }

    public T get(int index) {
        Node<T> node = head;
        for(int i=0; i < size; i++){
            if(index==i)
                return node.data;
            node = node.next;
        }
        return null;
    }

    public T set(int index, T element) {
        Node<T> node = head;
        for(int i=0; i < size; i++){
            if(index==i){
            node.data = element;
            return node.data;
            }
            node = node.next;
        }

        return null;
    }

    public boolean add(int index, T element) {
        if(index>size)
            return false;
        if(index==size){
            if(isEmpty()){
                head = new Node<>(element);
                tail = head;
                size++;
                return true;
            }
            if(head == tail){
                head.next = new Node<>(element); // head --> (new Node with data e)
                tail = head.next;    // head --> tail = the new Node
                tail.prev = head;    // head <--   (tail== the new Node) 
                size++;     // increase size now 1
                return true;
            }
            Node<T> node = new Node<>(element); // new node
            tail.next = node;    // (Node N tail) ---> new Node
            node.prev = tail;    // (Node N tail) <--- new Node
            tail = node;         // (new Node N+1) is now Tail
            size++;              // size = N+1
            return true;   

        }
        Node<T> node = new Node<>(element);
        Node<T> tmp;
        if(index<size/2){
            tmp = head;
            for(int i = 0; i < index; i++)
                tmp = tmp.next;
        }else{
            tmp = tail;
            for(int i = size-1; i > index; i--)
                tmp = tmp.prev;
        }
        node.next = tmp;
        node.prev = tmp.prev;
        if(tmp==head)
            head = node;
        else
            tmp.prev.next = node;
        tmp.prev = node;
        size++;
        return true;
    }


    public T remove(int index) {
        if(isEmpty()||index>=size)
            return null;
        Node<T> node;
        if(index<size/2){
            node = head;
            for(int i = 0; i < index; i++)
                node = node.next;
        }else{
            node = tail;
            for(int i = size-1; i > index; i--)
                node = node.prev;
        }
        if(node==head){
            head = head.next;
            head.prev = null;
            size--;
            return node.data;
        }
        node.prev.next = node.next;
        if(node==tail)
            node.prev = tail;
        else
            node.next.prev = node.prev;
        size--;
        return node.data;
    }


    public void showAll(){
        Node<T> node = head;
        for(int i = 0; i<size;i++){
            System.out.println(node.data);
            node=node.next;
        } 
    }



}