package com.tree.speedtest.customcomponents;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;

@JsModule("./tree-button-click.js")
public class TreeRowCaptionElement extends Div {

	private static final long serialVersionUID = 1L;
	
	Image image=new Image();
	
	Div captions=new Div();
	
	Span caption=new Span();
	
	Span progress=new Span();
	

	public TreeRowCaptionElement() {
		addClassName("item-caption");
		captions.addClassName("item-text");
		caption.addClassName("colBitemNameCaption");
		image.addClassName("item-icon");
		image.setAlt("");
		captions.add(caption);
		
		getElement().appendChild(image.getElement(),captions.getElement());
		
		UI.getCurrent().getPage().executeJs("addClickListener($0)",this);
	}
	
	@ClientCallable
	private void onItemClicked(boolean isDoubleClicked) {
		fireModelChangedEvent(isDoubleClicked);
	}

	public void setCaption(String caption) {
		this.caption.setText(caption);
	}

	public void setProgress(String progressValue) {
		
		if(captions.getElement().getChildCount()==1){
			captions.add(this.progress);
			this.progress.addClassNames("bold","colBitemProgressCaption");
		}
		
		this.progress.setText(progressValue);
	}

	public void setCaptionColor(String color) {
		caption.getStyle().set("color", color);
	}

	public void setIcon(String iconLocation) {
		image.setSrc(iconLocation);
	}

	public boolean hasClassName(String className) {
		return getElement().getClassList().contains(className);
	}

	public boolean removeClassName(String className) {
		return getElement().getClassList().remove(className);
	}

	public void addClassName(String className) {
		getElement().getClassList().add(className);

	}

	public void addClassNames(String... classes) {
		for (String className : classes) {
			getElement().getClassList().add(className);
		}
	}

	public void click() {
		fireModelChangedEvent(false);
	}

	/*public ColBItemRow getTreeItem() {
		return treeItem;
	}

	public void setTreeItem(ColBItemRow treeItem) {
		this.treeItem = treeItem;
	}*/

	private List<AddClickListener> listeners = null;

	public interface AddClickListener {
		public void addClickListener(ClickEvent event);
	}

	public class ClickEvent {
		boolean isDoubleClicked = false;

		public ClickEvent() {
		}

		public void setDoubleClicked(boolean isDoubleClicked) {
			this.isDoubleClicked = isDoubleClicked;
		}

		public boolean isDoubleClicked() {
			return this.isDoubleClicked;
		}
	}

	protected void fireModelChangedEvent(boolean isDoubleClick) {
		if (listeners != null) {
			ClickEvent event = new ClickEvent();
			event.setDoubleClicked(isDoubleClick);
			for (AddClickListener listener : listeners) {
				listener.addClickListener(event);
			}
		}
	}

	public void addClickListener(AddClickListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<AddClickListener>();
		}
		listeners.add(listener);
	}

	public void removeClickListener(AddClickListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<AddClickListener>();
		}
		listeners.remove(listener);
	}

}