package com.swings.jam.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonnguyen on 6/28/17.
 */
/* */
public class Node<T> {
    //list object value
    private List<Node<T>> children = new ArrayList<Node<T>>();
    // id of object
    private Node<T> parent = null;
    //object
    private T data = null;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }
    public Node child(T data){
       /*co 3 truong hop
       * Root : tao ra ten
       * leaf : cha cua no la parent
       * child : cha cua no la parent cua item
       * */
        if(this.isRoot()){
            return new Node(data);
        }
        else
            if(this.isLeaf()){
                return new Node(data,this.parent);
            }
        else
        for (Node item : children){
            if(item.data == data){
                return new Node(item,item.parent);
            }
        }
        return null;

    }
    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }
}