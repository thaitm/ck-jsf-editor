/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

/**
 * @fileOverview The "showblocks" plugin. Enable it will make all block level
 *               elements being decorated with a border and the element name
 *               displayed on the left-right corner.
 */

(function()
{
	var cssTemplate = '.%2 p,'+
		'.%2 div,'+
		'.%2 pre,'+
		'.%2 address,'+
		'.%2 blockquote,'+
		'.%2 h1,'+
		'.%2 h2,'+
		'.%2 h3,'+
		'.%2 h4,'+
		'.%2 h5,'+
		'.%2 h6'+
		'{'+
			'background-repeat: no-repeat;'+
			'background-position: top %3;'+
			'border: 1px dotted gray;'+
			'padding-top: 8px;'+
			'padding-%3: 8px;'+
		'}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 p'+
		'{'+ CKEDITOR.getUrl(
			'%1p.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 div'+
		'{'+ CKEDITOR.getUrl(
			'%1div.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 pre'+
		'{'+ CKEDITOR.getUrl(
			'%1pre.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 address'+
		'{'+ CKEDITOR.getUrl(
			'%1address.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 blockquote'+
		'{'+ CKEDITOR.getUrl(
			'%1blockquote.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 h1'+
		'{'+ CKEDITOR.getUrl(
			'%1h1.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 h2'+
		'{'+ CKEDITOR.getUrl(
			'%1h2.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 h3'+
		'{'+ CKEDITOR.getUrl(
			'%1h3.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 h4'+
		'{'+ CKEDITOR.getUrl(
			'%1h4.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 h5'+
		'{'+ CKEDITOR.getUrl(
			'%1h5.png);'
		) + '}'+

        /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
         *
         * Wrap the resource in the getUrl function so that jsf resource loading works.
         *
         */
		'.%2 h6'+
		'{'+ CKEDITOR.getUrl(
			'%1h6.png);'
		) + '}';

	var cssTemplateRegex = /%1/g, cssClassRegex = /%2/g, backgroundPositionRegex = /%3/g;

	var commandDefinition =
	{
		readOnly : 1,
		preserveState : true,
		editorFocus : false,

		exec : function ( editor )
		{
			this.toggleState();
			this.refresh( editor );
		},

		refresh : function( editor )
		{
			if ( editor.document )
			{
				var funcName = ( this.state == CKEDITOR.TRISTATE_ON ) ? 'addClass' : 'removeClass';
				editor.document.getBody()[ funcName ]( 'cke_show_blocks' );
			}
		}
	};

	CKEDITOR.plugins.add( 'showblocks',
	{
		requires : [ 'wysiwygarea' ],

		init : function( editor )
		{
			var command = editor.addCommand( 'showblocks', commandDefinition );
			command.canUndo = false;

			if ( editor.config.startupOutlineBlocks )
				command.setState( CKEDITOR.TRISTATE_ON );

			editor.addCss( cssTemplate
                /* CHANGED for CKJsfEditor component.  Please see CHANGES.txt for a complete list of changes.
                 *
                 * Moved the getUrl call into the template so that it works with jsf resource loading.
                 *
                 */
				.replace( cssTemplateRegex, 'background-image: url(' + this.path + 'images/block_' )
				.replace( cssClassRegex, 'cke_show_blocks ' )
				.replace( backgroundPositionRegex, editor.lang.dir == 'rtl' ? 'right' : 'left' ) );

			editor.ui.addButton( 'ShowBlocks',
				{
					label : editor.lang.showBlocks,
					command : 'showblocks'
				});

			// Refresh the command on setData.
			editor.on( 'mode', function()
				{
					if ( command.state != CKEDITOR.TRISTATE_DISABLED )
						command.refresh( editor );
				});

			// Refresh the command on setData.
			editor.on( 'contentDom', function()
				{
					if ( command.state != CKEDITOR.TRISTATE_DISABLED )
						command.refresh( editor );
				});
		}
	});
} )();

/**
 * Whether to automaticaly enable the "show block" command when the editor
 * loads. (StartupShowBlocks in FCKeditor)
 * @name CKEDITOR.config.startupOutlineBlocks
 * @type Boolean
 * @default false
 * @example
 * config.startupOutlineBlocks = true;
 */
