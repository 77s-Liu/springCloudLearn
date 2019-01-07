package com.springcloud.learn.blog_viewer_content.entity;

import java.util.List;

public class Node {
    private int id;
    private String text;
    private List<Node> nodes;

    public Node(int id, String text, List<Node> nodes) {
        this.id = id;
        this.text = text;
        this.nodes = nodes;
    }

    public Node() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
