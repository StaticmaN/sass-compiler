/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.sass.internal.tree.controldirective;

import java.util.ArrayList;

import com.vaadin.sass.internal.tree.Node;

/**
 * Temporary node used when expanding loops.
 */
public class TemporaryNode extends Node {

    public TemporaryNode() {
    }

    @Override
    public String toString() {
        return "Temporary Node: { " + getChildren().size() + " children }";
    }

    @Override
    public void traverse() {
        ArrayList<Node> children = new ArrayList<Node>(getChildren());
        getParentNode().replaceNode(this, children);
        for (Node node : children) {
            node.traverse();
        }
    }

}