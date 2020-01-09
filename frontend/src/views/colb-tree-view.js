import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `colb-tree-view`
 *
 * ColbTreeView element.
 *
 * @customElement
 * @polymer
 */
class ColbTreeView extends PolymerElement {

    static get template() {
        return html`
          <style>
	
	:host{
		 width: 100%;
	}
	
	.jibbytree
    {
        position: relative;
        display: block;
        width: 100%;
        top: 0;
        left: 0;
        z-index: 1;
    }
    .jibbytreeLeft
    {
        position: relative;
        background: #ffffff;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
      
    }

    
  .item-tree{
		background: transparent;
		border:none;
		float:left;
        cursor: pointer;
        padding-right: 5px;
        padding-left: 5px;
        width:12px;
	}

    .item-caption
    {
        position: relative;
        display: inline-flex;
        width:100%;
        padding: 0px;
        border: none;
        color: rgb(50, 50, 50);
        float:left;
        text-align: left;
        
        transition: background 0.3s, border 0.3s;
     
        cursor: pointer;
        background: transparent !important;
	 
        font-size: 13px;
        overflow: hidden;
        height: 26px;
    }
    .item-icon{
        max-width: 20px;
        max-height: 16px;
        padding-right: 5px;
        position: relative;
        top: 2px;
    }
    .item-text{
        padding-right:5px;
        font-weight:400;
        width: 100%;
    }

     .item-caption .item-caption-caption
    {
        margin: 0;
        padding: 0 0 0 10px;
    }
    
  .item-caption{
	    text-overflow: ellipsis;
	    display: flex;
	    width: 95%;
	    
	}
	
	.colBitemNameCaption {
	  
	    overflow: hidden;
	    float: left;
	    max-width: 90%;
	}
	.colBitemProgressCaption {
	    float: left;
	    padding-left: 5px;
	}
    
    .active
    {
        background: #e0edf7;
        border-left-width: 5px;
        border-left-color: #315871;
    }
    .subMenu
    {
       
        margin: 0 0 0 14px;
        width: calc(100% - 14px);
        overflow: hidden;
        position: relative;
        display: none;
        max-height: 0;
    }
    

    .subMenu.open
    {
        max-height: 100%;
        display:block;
    }

	.item-row-flex:hover{
		background: #e0edf7;
	}

	.item-row-flex:hover .hiddenable {
        display: inline-block;
     }
     
	.active .row{
		background: #e0edf7;
    	
	}
	.colb-attachment-preview{
		color: rgb(19, 93, 121);
		margin-left:10px;
	}
	
	.item-row-flex .hiddenable{
		display:none;
	}
	.checklistAddIcon{
		display:none;
	}
	
	.item-row-flex{
		display:inline-flex;
		padding-top: 5px;
		width:100%;
	}
	.fright{
        float:right;
	}
	.fleft{
        float:left;
	}
	.padding6{
        padding: 6px;
	}
	.bold{
        font-weight: 600;
	}
  .checklistWrapper {
	    border: 1px solid #ddd;
        padding: 0px;
	}
	.colbChecklistItemLayout {
	    padding: 0px 3px 0px 5px;
	    width: 98%;
	}
	 .emptyChecklistWrapper {
	    border: none !important;
	}
	.checklist-text-area{
        width:100%;
        height: 40px;
        padding: 0px;
	}
      
	
	.attachmentWrapper {
	    width: 94%;
	    border: 1px solid #ddd;
	    padding: 10px;
	}
	
	.borderlessbutton{
		background: none;
	    border: none;
	    cursor: pointer;
	    padding: 0px 3px;
	    height: 20px;
 }
.borderlessbutton:focus{
	outline: none;
}
.nochild{
    margin-left: 20px;
}

.submenu{
	padding-left:10px;
	display:none;
}
.open{
    display:block !important;
}
	
	
</style>
<div id="itemTreeWrapper">
  
</div>
        `;
    }

    static get is() {
        return 'colb-tree-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

window.scrollIntoTargetView = function(targetID){
	targetID.scrollIntoView({ behavior: 'instant', block:'center' });
}

customElements.define(ColbTreeView.is, ColbTreeView);
