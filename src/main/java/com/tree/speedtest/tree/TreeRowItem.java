package com.tree.speedtest.tree;

import com.tree.speedtest.bean.Project;
import com.tree.speedtest.customcomponents.TreeIconButton;
import com.tree.speedtest.customcomponents.TreeRowCaptionElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;


public class TreeRowItem extends Div{

	private static final long serialVersionUID = 1L;
	private Element activeButton;

	public TreeRowItem() {
		build();
	}


	private void build() {
		setSizeFull();

		addClassNames("jibbytreeLeft","jibbytree");

	}


	public TreeRowItemCache createItem(Project entity,String itemImage){


		TreeRowItemCache colBRowDTO = new TreeRowItemCache();

		Element mainElement = ElementFactory.createDiv();

		Element itemRow = ElementFactory.createDiv();
		itemRow.getClassList().add("row");
		itemRow.getClassList().add("itemrow");

		mainElement.appendChild(itemRow);

		Element  itemTextRow =  ElementFactory.createDiv();
		itemTextRow.getClassList().add("item-row-flex");
		itemRow.appendChild(itemTextRow);

		TreeRowCaptionElement itemTextContent = new TreeRowCaptionElement();

		if(entity.isChild()) {
			addTreeToggleIcon(colBRowDTO,itemTextRow);
			Element subMenu = addBlankSubMenu(mainElement);
			colBRowDTO.setSubMenu(subMenu);
		}else
			itemTextContent.getElement().getClassList().add("nochild");


		colBRowDTO.setItemText(itemTextContent);

		itemTextContent.setCaption(entity.getName());
		itemTextContent.setIcon(itemImage);


		Element elTextContent = itemTextContent.getElement();
		itemTextRow.appendChild(elTextContent);


		TreeIconButton actionListButton = new TreeIconButton();
		colBRowDTO.setMyactionListIcon(actionListButton);

		actionListButton.addClassNames("borderlessbutton","hiddenable");
		actionListButton.setIcon("images/mini_addmyactionlist.png", "");

		Element elActionListButton = actionListButton.getElement();
		itemTextRow.appendChild(elActionListButton);

		if(entity.isAttachement()) {
			TreeIconButton attachementButton = new TreeIconButton();
			colBRowDTO.setAttachmentIcon(attachementButton);
			attachementButton.setIcon("images/mini_paperclip.png", "");
			attachementButton.addClassNames("attachmentClose","borderlessbutton","fright");
			itemTextRow.appendChild(attachementButton.getElement());

		}

		TreeIconButton checkElement = new TreeIconButton();
		colBRowDTO.setCheckListIcon(checkElement);

		if(!entity.isCheckList())
			checkElement.addClassName("hiddenable");

		checkElement.setIcon("images/mini_checklist_close.png", "");
		checkElement.addClassName("borderlessbutton");
		itemTextRow.appendChild(checkElement.getElement());

		colBRowDTO.setRowItem(mainElement);

		return colBRowDTO;
	}

	public void openNode(TreeRowItemCache item){
		item.getSubMenu().getClassList().add("open");
		item.getTreeButton().setIcon("images/mini_expand.png","Fold");
	}


	private void addTreeToggleIcon(TreeRowItemCache colBRowDTO,Element itemTextRow) {

		TreeIconButton iconTree = new TreeIconButton();
		iconTree.addClassName("borderlessbutton");
		colBRowDTO.setTreeButton(iconTree);

		iconTree.addClickListener(e->treeButtonIconChanged(colBRowDTO,iconTree));

		Element treeButton = iconTree.getElement();
		iconTree.setIcon("images/mini_collapse.png", "Fold");
		itemTextRow.insertChild(0, treeButton);

	}

	public void setActiveItem(Element activeItem){
		activeButton=activeItem;
	}

	public void treeButtonIconChanged(TreeRowItemCache colBRow,TreeIconButton iconTree){

		if (colBRow.getSubMenu().getClassList().contains("open")) {
			colBRow.getSubMenu().getClassList().remove("open");
			iconTree.setIcon("images/mini_collapse.png","Un-fold");
		} else {

			colBRow.getSubMenu().getClassList().add("open");
			iconTree.setIcon("images/mini_expand.png","Fold");

		}
	}

	public void addChild(TreeRowItemCache child){

		if(child.getParent()!=null){
			addChild(child,child.getParent().getSubMenu(),null);
		}else{
			addChild(child,this.getElement(),null);
		}
	}

	public void addChild(TreeRowItemCache menuItem,Integer index){

		addChild(menuItem, menuItem.getParent().getSubMenu(),index);

	}

	private Element addBlankSubMenu(Element mainElement){
		Element subMenu = ElementFactory.createDiv();
		subMenu.getClassList().add("submenu");
		mainElement.appendChild(subMenu);
		return subMenu;
	}

	public void addChild(TreeRowItemCache childItem,Element mainLayout,Integer index){

		TreeRowItemCache parentRow = childItem.getParent();

		if(parentRow!=null && mainLayout==null){

			parentRow.getItemText().getElement().getClassList().remove("nochild");
			Element itemTextRow= parentRow.getRowItem().getChild(0).getChild(0);
			addTreeToggleIcon(parentRow,itemTextRow);
			mainLayout = addBlankSubMenu(parentRow.getRowItem());
			parentRow.setSubMenu(mainLayout);

		}

		if(mainLayout!=null && childItem.getRowItem()!=null && index==null)
			mainLayout.appendChild(childItem.getRowItem());
		else if(mainLayout!=null && childItem.getRowItem()!=null && index!=null)
			mainLayout.insertChild(index, childItem.getRowItem());

	}




}
