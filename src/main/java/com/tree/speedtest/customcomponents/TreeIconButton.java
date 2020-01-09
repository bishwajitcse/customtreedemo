package com.tree.speedtest.customcomponents;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;

@Tag(Tag.BUTTON)
public class TreeIconButton extends Component implements ClickNotifier<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Element button = this.getElement();


	public TreeIconButton() {

	}


	public void setIcon(String iconLocation,String alt) {
		Element icon;
		
		if(button.getChildCount() == 0){
			icon = new Element("img");
			button.appendChild(icon);
		}else{
			icon = button.getChild(0);
		}

		icon.setAttribute("src", iconLocation);
		icon.setAttribute("alt", alt);

	}

	public boolean hasClassName(String className) {
		return button.getClassList().contains(className);
	}

	public void removeClassName(String className) {
		button.getClassList().remove(className);
	}

	public void addClassName(String className) {
		button.getClassList().add(className);

	}

	public void addClassNames(String... classes) {
		for(String className:classes) {
			button.getClassList().add(className);
		}
	}

	public void click() {
		fireEvent(new ClickEvent<Component>(this));
	}

}