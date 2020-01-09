package com.tree.speedtest;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

	@Inject private TreeViewWrapper treeView;
	
	public MainView() {
		
	}
	
    @PostConstruct
    public void init() {
        add(treeView);
    }

}
