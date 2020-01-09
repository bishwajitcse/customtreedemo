package com.tree.speedtest.tree;

import java.util.ArrayList;
import java.util.List;

import com.tree.speedtest.bean.Project;
import com.tree.speedtest.customcomponents.TreeIconButton;
import com.tree.speedtest.customcomponents.TreeRowCaptionElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;

public class TreeRowItemCache {
	
	private boolean isChild,isChecklist,isAttachment;
	
	private TreeRowItemCache parent;
	
	private Element subMenu;
	
	private Element rowItem;
	
	private TreeIconButton treeButton;
	private TreeIconButton myactionlistButton;
	private TreeIconButton attachmentButton;
	private TreeIconButton checkListIcon;
	
	private TreeRowCaptionElement itemText;
	
	private Div checklistLayout,attachmentLayout;
	
	private Project jbentity; 
	

	
	public void setIsAttachment(boolean isAttachment){
		this.isAttachment=isAttachment;
	}
	
	public boolean getIsAttachment(){
		return this.isAttachment;
	}
	
	public void setIsChild(boolean isChild){
		this.isChild=isChild;
	}
	
	public boolean getIsChild(){
		return this.isChild;
	}
	
	public boolean getIsChecklist(){
		return this.isChecklist;
	}
	
	public void setIsChecklist(boolean isChecklist){
		this.isChecklist=isChecklist;
	}
	
	public void setParent(TreeRowItemCache parent){
		this.parent= parent;
	}
	
	public TreeRowItemCache getParent(){
		return this.parent;
	}
	
	public Element getRowItem() {
		return rowItem;
	}

	
	public void setRowItem(Element rowItem) {
		this.rowItem = rowItem;
	}


	public void setSubMenu(Element subMenu){
		this.subMenu=subMenu;
	}
	
	public Element getSubMenu(){
		return this.subMenu;
	}
	
	public Div getChecklistComponent(){
		return this.checklistLayout;
	}
	
	public void setChecklistComponent(Div checklistLayout){
		this.checklistLayout=checklistLayout;
	}
	
	public Div getAttachmentComponent(){
		return this.attachmentLayout;
	}
	
	public void setAttachmentComponent(Div attachmentLayout){
		this.attachmentLayout=attachmentLayout;
	}

	
	
	public TreeIconButton getTreeButton() {
		return treeButton;
	}

	public void setTreeButton(TreeIconButton treeButton) {
		this.treeButton = treeButton;
	}
	
	
	public TreeIconButton getMyactionListIcon() {
		return myactionlistButton;
	}
	public void setMyactionListIcon(TreeIconButton myactionlistButton) {
		this.myactionlistButton = myactionlistButton;
	}
	
	public TreeIconButton getAttachmentIcon() {
		return attachmentButton;
	}
	public void setAttachmentIcon(TreeIconButton attachmentButton) {
		this.attachmentButton = attachmentButton;
	}
	
	public TreeIconButton getCheckListIcon() {
		return checkListIcon;
	}
	public void setCheckListIcon(TreeIconButton checkListIcon) {
		this.checkListIcon = checkListIcon;
	}
	
	
	
	public TreeRowCaptionElement getItemText() {
		return itemText;
	}

	public void setItemText(TreeRowCaptionElement itemText) {
		this.itemText = itemText;
	}
	
	public Element getActiveItemText() {
		return this.rowItem.getChild(0).getChild(0);
	}

	
	public Project getJBEntity() {
		return jbentity;
	}


	public void setJBEntity(Project jbentity) {
		this.jbentity = jbentity;
	}


	
	
	
}
