package com.tree.speedtest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import com.tree.speedtest.bean.Project;
import com.tree.speedtest.tree.TreeRowItem;
import com.tree.speedtest.tree.TreeRowItemCache;
import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("colb-tree-view")
@JsModule("./src/views/colb-tree-view.js")
@UIScoped
public class TreeViewWrapper extends PolymerTemplate<TreeViewWrapper.ColBTreeViewModel>{

	Logger logger = Logger.getLogger(TreeViewWrapper.class.getName());

	@Id("itemTreeWrapper")
	private Div itemTreeWrapper;

	private TreeRowItem itemTree;

	private int totalLevel=1;

	public TreeViewWrapper() {}

	@PostConstruct
	public void init() {
	
		loadItem();	
	}


	private void loadItem(){

		itemTree = new TreeRowItem();

		Project topItemDTO = new Project();
		topItemDTO.setName("Dummy Project bla bla bla...");
		topItemDTO.setChild(true);
		topItemDTO.setAttachement(true);

		TreeRowItemCache topItemLevelElement = itemTree.createItem(topItemDTO, "images/mini_project.png");
		itemTree.addChild(topItemLevelElement);

		itemTree.openNode(topItemLevelElement);
		addChild(topItemLevelElement,generateDummyData());

		itemTreeWrapper.add(itemTree);
		
		itemTree.setActiveItem(topItemLevelElement.getActiveItemText());
		
		logger.info("Total level added:"+totalLevel);
	}



	public void addChild(TreeRowItemCache parentItem,List<Project> dataSet) {

		for (Project itemDTO : dataSet) {
			TreeRowItemCache item = itemTree.createItem(itemDTO, "images/mini_project.png");
			item.setParent(parentItem);
			
			totalLevel++;
			
			
			if(itemDTO.isChild()){
				itemTree.openNode(item);
				addChild(item, getChildLevelData());
			}
			
			itemTree.addChild(item);
		}

	}


	// generate dummy data
	public List<Project> generateDummyData(){
		
		List<Project> dataSet = new ArrayList<>();

		for(int i=0;i<500;i++){
			Project item = new Project();
			item.setName("Dummy Project bla bla bla..."+i);
			item.setChild(i%2==0);
			item.setAttachement(true);
			if(i%3==0)
				item.setProgress(i*5);

			dataSet.add(item);
		}
		return dataSet;

	}
	
	
	private List<Project> getChildLevelData(){
		
		List<Project> childs= new ArrayList<>();
		
		for(int i=0;i<5;i++){
			Project item = new Project();
			item.setName("Child level bla bla bla..."+i);
			item.setChild(false);
			item.setAttachement(true);
			item.setCheckList(true);

			childs.add(item);
		}
		return childs;
		
		
	}

	public interface ColBTreeViewModel extends TemplateModel {}

}
