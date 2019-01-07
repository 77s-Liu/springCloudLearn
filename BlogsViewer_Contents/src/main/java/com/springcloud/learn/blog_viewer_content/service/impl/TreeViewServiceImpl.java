package com.springcloud.learn.blog_viewer_content.service.impl;

import com.springcloud.learn.blog_viewer_content.entity.Node;
import com.springcloud.learn.blog_viewer_content.service.TreeViewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeViewServiceImpl implements TreeViewService {
    @Override
    public List<Node> getNodeList() {
        List<Node> result = new ArrayList<Node>();
        for(int i=0;i<4;i++){
            Node node = new Node();
            node.setId(i+1);
            node.setText("Node"+(i+1));
            List<Node> nodes = new ArrayList<Node>();
            for(int j=0;j<2;j++){
                Node child = new Node();
                child.setId(11+j);
                child.setText("child"+(11+j));
                nodes.add(child);
            }
            node.setNodes(nodes);
            result.add(node);
        }
        return result;
    }
}
