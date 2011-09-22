/*
 * ck-jsf-editor is a JSF2 component for ckEditor (see http://ckeditor.com)
 *     Copyright (C) 2011  Bill Reh
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.google.code.ckJsfEditor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Vector;

/**
 * <p>
 * A java object to represent the ckeditor configuration javascript object.  It is serialized to json and
 * fed to the editor at startup time.
 * </p>
 *
 * <p>
 * Please see the ckeditor documentation at <a href="http://docs.cksource.com/ckeditor_api/symbols/CKEDITOR.config.html">
 * http://docs.cksource.com/ckeditor_api/symbols/CKEDITOR.config.html</a> for details on what all of the options do.
 * </p>
 *
 * <p>
 * The object is designed so that you can use method chaining during creation.  For example:<br/>
 * <code>
 *     Config config = new Config().uiColor("#aed0ea").language("fr").width("500px");
 * </code>
 * </p>
 * <p>
 * This config object can now be bound to the tag like so:<br/>
 * <code>
 *     &lt;ck:editor value="#{editorBean.contents}" config="#{editorBean.config}"/&gt;
 * </code>
 * </p>
 *
 * Pretty printing can be turned on an off via the {@link #setPrettyPrint(boolean)} method.
 *
 * @author Bill Reh
 */
public class Config {
    private static final Gson gson = new Gson();
    private static final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

    private Integer autoGrow_bottomSpace;
    private Integer autoGrow_maxHeight;
    private Integer autoGrow_minHeight;
    private Boolean autoGrow_onStartup;
    private Boolean autoParagraph;
    private Boolean autoUpdateElement;
    private Integer baseFloatZIndex;
    private String baseHref;
    private Boolean basicEntities;
    private String[] blockedKeystrokes;
    private String bodyClass;
    private String bodyId;
    private Boolean browserContextMenuOnCtrl;
    private BasicStyle colorButton_backStyle;
    private String colorButton_colors;
    private Boolean colorButton_enableMore;
    private BasicStyle colorButton_foreStyle;
    private String[] contentsCss;
    private String contentsLangDirection;
    private String contentsLanguage;
    private String corePlugins;
    private InlineStyleOverride coreStyles_bold;
    private InlineStyleOverride coreStyles_italic;
    private InlineStyleOverride coreStyles_strike;
    private InlineStyleOverride coreStyles_subscript;
    private InlineStyleOverride coreStyles_superscript;
    private InlineStyleOverride coreStyles_underline;
    private String customConfig;
    private String defaultLanguage;
    private String devtools_styles;
    private String dialog_backgroundCoverColor;
    private Integer dialog_backgroundCoverOpacity;
    private String dialog_buttonsOrder;
    private Integer dialog_magnetDistance;
    private Boolean dialog_startupFocusTab;
    private Boolean disableNativeSpellChecker;
    private Boolean disableNativeTableHandles;
    private Boolean disableObjectResizing;
    private Boolean disableReadonlyStyling;
    private String docType;
    private Boolean editingBlock;
    private String emailProtection;
    private Boolean enableTabKeyTools;
    private Integer enterMode;
    private Boolean entities;
    private String entities_additional;
    private Boolean entities_greek;
    private Boolean entities_latin;
    private Boolean entities_processNumerical;
    private String extraPlugins;
    private String filebrowserBrowseUrl;
    private String filebrowserFlashBrowseUrl;
    private String filebrowserFlashUploadUrl;
    private String filebrowserImageBrowseLinkUrl;
    private String filebrowserImageBrowseUrl;
    private String filebrowserImageUploadUrl;
    private String filebrowserUploadUrl;
    private String filebrowserWindowFeatures;
    private String filebrowserWindowHeight;
    private String filebrowserWindowWidth;
    private Boolean fillEmptyBlocks;
    private BasicStyle find_highlight;
    private String font_defaultLabel;
    private String font_names;
    private BasicStyleOverride font_style;
    private String fontSize_defaultLabel;
    private String fontSize_sizes;
    private BasicStyleOverride fontSize_style;
    private Boolean forceEnterMode;
    private Boolean forcePasteAsPlainText;
    private Boolean forceSimpleAmpersand;
    private InlineStyle format_address;
    private InlineStyle format_div;
    private InlineStyle format_h1;
    private InlineStyle format_h2;
    private InlineStyle format_h3;
    private InlineStyle format_h4;
    private InlineStyle format_h5;
    private InlineStyle format_h6;
    private InlineStyle format_p;
    private InlineStyle format_pre;
    private String format_tags;
    private Boolean fullPage;
    private String height;
    private Boolean htmlEncodeOutput;
    private Boolean ignoreEmptyParagraph;
    private String image_previewText;
    private Boolean image_removeLinkByEmptyURL;
    private String[] indentClasses;
    private Integer indentOffset;
    private String indentUnit;
    private Boolean jqueryOverrideVal;
    private String[] justifyClasses;
    private String[] keystrokes;
    private String language;
    private String menu_groups;
    private String newpage_html;
    private String pasteFromWordCleanupFile;
    private Boolean pasteFromWordNumberedHeadingToList;
    private Boolean pasteFromWordPromptCleanup;
    private Boolean pasteFromWordRemoveFontStyles;
    private Boolean pasteFromWordRemoveStyles;
    private String plugins;
    private String[] protectedSource;
    private Boolean readOnly;
    private String removeDialogTabs;
    private String removeFormatAttributes;
    private String removeFormatTags;
    private String removePlugins;
    private String resize_dir;
    private Boolean resize_enabled;
    private Integer resize_maxHeight;
    private Integer resize_maxWidth;
    private Integer resize_minHeight;
    private Integer resize_minWidth;
    private Boolean scayt_autoStartup;
    private String scayt_contextCommands;
    private String scayt_contextMenuItemsOrder;
    private String scayt_customDictionaryIds;
    private String scayt_customerid;
    private Integer scayt_maxSuggestions;
    private String scayt_moreSuggestions;
    private String scayt_sLang;
    private String scayt_srcUrl;
    private String scayt_uiTabs;
    private String scayt_userDictionaryName;
    private SharedSpaces sharedSpaces;
    private Integer shiftEnterMode;
    private String skin;
    private Integer smiley_columns;
    private String[] smiley_descriptions;
    private String[] smiley_images;
    private String smiley_path;
    private String[] specialChars;
    private Boolean startupFocus;
    private String startupMode;
    private Boolean startupOutlineBlocks;
    private Boolean startupShowBorders;
    private String stylesheetParser_skipSelectors;
    private String stylesheetParser_validSelectors;
    private String stylesSet;
    private Integer tabIndex;
    private Integer tabSpaces;
    private Integer templates_files;
    private Boolean templates_replaceContent;
    private String theme;
    private List<ToolbarButtonGroup> toolbar;
    private Boolean toolbarCanCollapse;
    private Boolean toolbarGroupCycling;
    private String toolbarLocation;
    private Boolean toolbarStartupExpanded;
    private String uiColor;
    private Integer undoStackSize;
    private Boolean useComputedState;
    private String width;

    private transient boolean prettyPrint = false; // don't serialize this field to json via transient

    /**
     *
     * @return true if this Config object is set to pretty print.
     */
    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    /**
     * Set the Config object to pretty print or not, default is false.
     *
     * @param prettyPrint true to pretty print.
     */
    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
    }

    /**
     * This method will turn the Config object into a CKEDITOR.config string representation.
     *
     * @return A json representation of the CKEDITOR.config object
     */
    public String toJson() {
        if(isPrettyPrint())
            return prettyGson.toJson(this, this.getClass());
        else
            return gson.toJson(this, this.getClass());
    }

    @Override
    public String toString() {
        return toJson();
    }

    public Config autoGrowBottomSpace(Integer autoGrow_bottomSpace) {
        setAutoGrow_bottomSpace(autoGrow_bottomSpace);
        return this;
    }
    public Config autoGrowMaxHeight(Integer autoGrow_maxHeight) {
        setAutoGrow_maxHeight(autoGrow_maxHeight);
        return this;
    }
    public Config autoGrowMinHeight(Integer autoGrow_minHeight) {
        setAutoGrow_minHeight(autoGrow_minHeight);
        return this;
    }
    public Config autoGrowOnStartup(Boolean autoGrow_onStartup) {
        setAutoGrow_onStartup(autoGrow_onStartup);
        return this;
    }
    public Config autoParagraph(Boolean autoParagraph) {
        setAutoParagraph(autoParagraph);
        return this;
    }
    public Config autoUpdateElement(Boolean autoUpdateElement) {
        setAutoUpdateElement(autoUpdateElement);
        return this;
    }
    public Config baseFloatZIndex(Integer baseFloatZIndex) {
        setBaseFloatZIndex(baseFloatZIndex);
        return this;
    }
    public Config baseHref(String baseHref) {
        setBaseHref(baseHref);
        return this;
    }
    public Config basicEntities(Boolean basicEntities) {
        setBasicEntities(basicEntities);
        return this;
    }
    public Config blockedKeystrokes(String[] blockedKeystrokes) {
        setBlockedKeystrokes(blockedKeystrokes);
        return this;
    }
    public Config bodyClass(String bodyClass) {
        setBodyClass(bodyClass);
        return this;
    }
    public Config bodyId(String bodyId) {
        setBodyId(bodyId);
        return this;
    }
    public Config browserContextMenuOnCtrl(Boolean browserContextMenuOnCtrl) {
        setBrowserContextMenuOnCtrl(browserContextMenuOnCtrl);
        return this;
    }
    public Config colorButtonBackStyle(BasicStyle colorButton_backStyle) {
        setColorButton_backStyle(colorButton_backStyle);
        return this;
    }
    public Config colorButtonColors(String colorButton_colors) {
        setColorButton_colors(colorButton_colors);
        return this;
    }
    public Config colorButtonEnableMore(Boolean colorButton_enableMore) {
        setColorButton_enableMore(colorButton_enableMore);
        return this;
    }
    public Config colorButtonForeStyle(BasicStyle colorButton_foreStyle) {
        setColorButton_foreStyle(colorButton_foreStyle);
        return this;
    }
    public Config contentsCss(String[] contentsCss) {
        setContentsCss(contentsCss);
        return this;
    }
    public Config contentsLangDirection(String contentsLangDirection) {
        setContentsLangDirection(contentsLangDirection);
        return this;
    }
    public Config contentsLanguage(String contentsLanguage) {
        setContentsLanguage(contentsLanguage);
        return this;
    }
    public Config corePlugins(String corePlugins) {
        setCorePlugins(corePlugins);
        return this;
    }
    public Config coreStylesBold(InlineStyleOverride coreStyles_bold) {
        setCoreStyles_bold(coreStyles_bold);
        return this;
    }
    public Config coreStylesItalic(InlineStyleOverride coreStyles_italic) {
        setCoreStyles_italic(coreStyles_italic);
        return this;
    }
    public Config coreStylesStrike(InlineStyleOverride coreStyles_strike) {
        setCoreStyles_strike(coreStyles_strike);
        return this;
    }
    public Config coreStylesSubscript(InlineStyleOverride coreStyles_subscript) {
        setCoreStyles_subscript(coreStyles_subscript);
        return this;
    }
    public Config coreStylesSuperscript(InlineStyleOverride coreStyles_superscript) {
        setCoreStyles_superscript(coreStyles_superscript);
        return this;
    }
    public Config coreStylesUnderline(InlineStyleOverride coreStyles_underline) {
        setCoreStyles_underline(coreStyles_underline);
        return this;
    }
    public Config customConfig(String customConfig) {
        setCustomConfig(customConfig);
        return this;
    }
    public Config defaultLanguage(String defaultLanguage) {
        setDefaultLanguage(defaultLanguage);
        return this;
    }
    public Config devtoolsStyles(String devtools_styles) {
        setDevtools_styles(devtools_styles);
        return this;
    }
    public Config dialogBackgroundCoverColor(String dialog_backgroundCoverColor) {
        setDialog_backgroundCoverColor(dialog_backgroundCoverColor);
        return this;
    }
    public Config dialogBackgroundCoverOpacity(Integer dialog_backgroundCoverOpacity) {
        setDialog_backgroundCoverOpacity(dialog_backgroundCoverOpacity);
        return this;
    }
    public Config dialogButtonsOrder(String dialog_buttonsOrder) {
        setDialog_buttonsOrder(dialog_buttonsOrder);
        return this;
    }
    public Config dialogMagnetDistance(Integer dialog_magnetDistance) {
        setDialog_magnetDistance(dialog_magnetDistance);
        return this;
    }
    public Config dialogStartupFocusTab(Boolean dialog_startupFocusTab) {
        setDialog_startupFocusTab(dialog_startupFocusTab);
        return this;
    }
    public Config disableNativeSpellChecker(Boolean disableNativeSpellChecker) {
        setDisableNativeSpellChecker(disableNativeSpellChecker);
        return this;
    }
    public Config disableNativeTableHandles(Boolean disableNativeTableHandles) {
        setDisableNativeTableHandles(disableNativeTableHandles);
        return this;
    }
    public Config disableObjectResizing(Boolean disableObjectResizing) {
        setDisableObjectResizing(disableObjectResizing);
        return this;
    }
    public Config disableReadonlyStyling(Boolean disableReadonlyStyling) {
        setDisableReadonlyStyling(disableReadonlyStyling);
        return this;
    }
    public Config docType(String docType) {
        setDocType(docType);
        return this;
    }
    public Config editingBlock(Boolean editingBlock) {
        setEditingBlock(editingBlock);
        return this;
    }
    public Config emailProtection(String emailProtection) {
        setEmailProtection(emailProtection);
        return this;
    }
    public Config enableTabKeyTools(Boolean enableTabKeyTools) {
        setEnableTabKeyTools(enableTabKeyTools);
        return this;
    }
    public Config enterMode(EnterMode enterMode) {
        setEnterMode(enterMode.getValue());
        return this;
    }
    public Config entities(Boolean entities) {
        setEntities(entities);
        return this;
    }
    public Config entitiesAdditional(String entities_additional) {
        setEntities_additional(entities_additional);
        return this;
    }
    public Config entitiesGreek(Boolean entities_greek) {
        setEntities_greek(entities_greek);
        return this;
    }
    public Config entitiesLatin(Boolean entities_latin) {
        setEntities_latin(entities_latin);
        return this;
    }
    public Config entitiesProcessNumerical(Boolean entities_processNumerical) {
        setEntities_processNumerical(entities_processNumerical);
        return this;
    }
    public Config extraPlugins(String extraPlugins) {
        setExtraPlugins(extraPlugins);
        return this;
    }
    public Config filebrowserBrowseUrl(String filebrowserBrowseUrl) {
        setFilebrowserBrowseUrl(filebrowserBrowseUrl);
        return this;
    }
    public Config filebrowserFlashBrowseUrl(String filebrowserFlashBrowseUrl) {
        setFilebrowserFlashBrowseUrl(filebrowserFlashBrowseUrl);
        return this;
    }
    public Config filebrowserFlashUploadUrl(String filebrowserFlashUploadUrl) {
        setFilebrowserFlashUploadUrl(filebrowserFlashUploadUrl);
        return this;
    }
    public Config filebrowserImageBrowseLinkUrl(String filebrowserImageBrowseLinkUrl) {
        setFilebrowserImageBrowseLinkUrl(filebrowserImageBrowseLinkUrl);
        return this;
    }
    public Config filebrowserImageBrowseUrl(String filebrowserImageBrowseUrl) {
        setFilebrowserImageBrowseUrl(filebrowserImageBrowseUrl);
        return this;
    }
    public Config filebrowserImageUploadUrl(String filebrowserImageUploadUrl) {
        setFilebrowserImageUploadUrl(filebrowserImageUploadUrl);
        return this;
    }
    public Config filebrowserUploadUrl(String filebrowserUploadUrl) {
        setFilebrowserUploadUrl(filebrowserUploadUrl);
        return this;
    }
    public Config filebrowserWindowFeatures(String filebrowserWindowFeatures) {
        setFilebrowserWindowFeatures(filebrowserWindowFeatures);
        return this;
    }
    public Config filebrowserWindowHeight(String filebrowserWindowHeight) {
        setFilebrowserWindowHeight(filebrowserWindowHeight);
        return this;
    }
    public Config filebrowserWindowWidth(String filebrowserWindowWidth) {
        setFilebrowserWindowWidth(filebrowserWindowWidth);
        return this;
    }
    public Config fillEmptyBlocks(Boolean fillEmptyBlocks) {
        setFillEmptyBlocks(fillEmptyBlocks);
        return this;
    }
    public Config findHighlight(BasicStyle find_highlight) {
        setFind_highlight(find_highlight);
        return this;
    }
    public Config fontDefaultLabel(String font_defaultLabel) {
        setFont_defaultLabel(font_defaultLabel);
        return this;
    }
    public Config fontNames(String font_names) {
        setFont_names(font_names);
        return this;
    }
    public Config fontStyle(BasicStyleOverride font_style) {
        setFont_style(font_style);
        return this;
    }
    public Config fontSizeDefaultLabel(String fontSize_defaultLabel) {
        setFontSize_defaultLabel(fontSize_defaultLabel);
        return this;
    }
    public Config fontSizeSizes(String fontSize_sizes) {
        setFontSize_sizes(fontSize_sizes);
        return this;
    }
    public Config fontSizeStyle(BasicStyleOverride fontSize_style) {
        setFontSize_style(fontSize_style);
        return this;
    }
    public Config forceEnterMode(Boolean forceEnterMode) {
        setForceEnterMode(forceEnterMode);
        return this;
    }
    public Config forcePasteAsPlainText(Boolean forcePasteAsPlainText) {
        setForcePasteAsPlainText(forcePasteAsPlainText);
        return this;
    }
    public Config forceSimpleAmpersand(Boolean forceSimpleAmpersand) {
        setForceSimpleAmpersand(forceSimpleAmpersand);
        return this;
    }
    public Config formatAddress(InlineStyle format_address) {
        setFormat_address(format_address);
        return this;
    }
    public Config formatDiv(InlineStyle format_div) {
        setFormat_div(format_div);
        return this;
    }
    public Config formatH1(InlineStyle format_h1) {
        setFormat_h1(format_h1);
        return this;
    }
    public Config formatH2(InlineStyle format_h2) {
        setFormat_h2(format_h2);
        return this;
    }
    public Config formatH3(InlineStyle format_h3) {
        setFormat_h3(format_h3);
        return this;
    }
    public Config formatH4(InlineStyle format_h4) {
        setFormat_h4(format_h4);
        return this;
    }
    public Config formatH5(InlineStyle format_h5) {
        setFormat_h5(format_h5);
        return this;
    }
    public Config formatH6(InlineStyle format_h6) {
        setFormat_h6(format_h6);
        return this;
    }
    public Config formatP(InlineStyle format_p) {
        setFormat_p(format_p);
        return this;
    }
    public Config formatPre(InlineStyle format_pre) {
        setFormat_pre(format_pre);
        return this;
    }
    public Config formatTags(String format_tags) {
        setFormat_tags(format_tags);
        return this;
    }
    public Config fullPage(Boolean fullPage) {
        setFullPage(fullPage);
        return this;
    }
    public Config height(String height) {
        setHeight(height);
        return this;
    }
    public Config htmlEncodeOutput(Boolean htmlEncodeOutput) {
        setHtmlEncodeOutput(htmlEncodeOutput);
        return this;
    }
    public Config ignoreEmptyParagraph(Boolean ignoreEmptyParagraph) {
        setIgnoreEmptyParagraph(ignoreEmptyParagraph);
        return this;
    }
    public Config imagePreviewText(String image_previewText) {
        setImage_previewText(image_previewText);
        return this;
    }
    public Config imageRemoveLinkByEmptyURL(Boolean image_removeLinkByEmptyURL) {
        setImage_removeLinkByEmptyURL(image_removeLinkByEmptyURL);
        return this;
    }
    public Config indentClasses(String[] indentClasses) {
        setIndentClasses(indentClasses);
        return this;
    }
    public Config indentOffset(Integer indentOffset) {
        setIndentOffset(indentOffset);
        return this;
    }
    public Config indentUnit(String indentUnit) {
        setIndentUnit(indentUnit);
        return this;
    }
    public Config jqueryOverrideVal(Boolean jqueryOverrideVal) {
        setJqueryOverrideVal(jqueryOverrideVal);
        return this;
    }
    public Config justifyClasses(String[] justifyClasses) {
        setJustifyClasses(justifyClasses);
        return this;
    }
    public Config keystrokes(String[] keystrokes) {
        setKeystrokes(keystrokes);
        return this;
    }
    public Config language(String language) {
        setLanguage(language);
        return this;
    }
    public Config menuGroups(String menu_groups) {
        setMenu_groups(menu_groups);
        return this;
    }
    public Config newpageHtml(String newpage_html) {
        setNewpage_html(newpage_html);
        return this;
    }
    public Config pasteFromWordCleanupFile(String pasteFromWordCleanupFile) {
        setPasteFromWordCleanupFile(pasteFromWordCleanupFile);
        return this;
    }
    public Config pasteFromWordNumberedHeadingToList(Boolean pasteFromWordNumberedHeadingToList) {
        setPasteFromWordNumberedHeadingToList(pasteFromWordNumberedHeadingToList);
        return this;
    }
    public Config pasteFromWordPromptCleanup(Boolean pasteFromWordPromptCleanup) {
        setPasteFromWordPromptCleanup(pasteFromWordPromptCleanup);
        return this;
    }
    public Config pasteFromWordRemoveFontStyles(Boolean pasteFromWordRemoveFontStyles) {
        setPasteFromWordRemoveFontStyles(pasteFromWordRemoveFontStyles);
        return this;
    }
    public Config pasteFromWordRemoveStyles(Boolean pasteFromWordRemoveStyles) {
        setPasteFromWordRemoveStyles(pasteFromWordRemoveStyles);
        return this;
    }
    public Config plugins(String plugins) {
        setPlugins(plugins);
        return this;
    }
    public Config protectedSource(String[] protectedSource) {
        setProtectedSource(protectedSource);
        return this;
    }
    public Config readOnly(Boolean readOnly) {
        setReadOnly(readOnly);
        return this;
    }
    public Config removeDialogTabs(String removeDialogTabs) {
        setRemoveDialogTabs(removeDialogTabs);
        return this;
    }
    public Config removeFormatAttributes(String removeFormatAttributes) {
        setRemoveFormatAttributes(removeFormatAttributes);
        return this;
    }
    public Config removeFormatTags(String removeFormatTags) {
        setRemoveFormatTags(removeFormatTags);
        return this;
    }
    public Config removePlugins(String removePlugins) {
        setRemovePlugins(removePlugins);
        return this;
    }
    public Config resizeDir(String resize_dir) {
        setResize_dir(resize_dir);
        return this;
    }
    public Config resizeEnabled(Boolean resize_enabled) {
        setResize_enabled(resize_enabled);
        return this;
    }
    public Config resizeMaxHeight(Integer resize_maxHeight) {
        setResize_maxHeight(resize_maxHeight);
        return this;
    }
    public Config resizeMaxWidth(Integer resize_maxWidth) {
        setResize_maxWidth(resize_maxWidth);
        return this;
    }
    public Config resizeMinHeight(Integer resize_minHeight) {
        setResize_minHeight(resize_minHeight);
        return this;
    }
    public Config resizeMinWidth(Integer resize_minWidth) {
        setResize_minWidth(resize_minWidth);
        return this;
    }
    public Config scaytAutoStartup(Boolean scayt_autoStartup) {
        setScayt_autoStartup(scayt_autoStartup);
        return this;
    }
    public Config scaytContextCommands(String scayt_contextCommands) {
        setScayt_contextCommands(scayt_contextCommands);
        return this;
    }
    public Config scaytContextMenuItemsOrder(String scayt_contextMenuItemsOrder) {
        setScayt_contextMenuItemsOrder(scayt_contextMenuItemsOrder);
        return this;
    }
    public Config scaytCustomDictionaryIds(String scayt_customDictionaryIds) {
        setScayt_customDictionaryIds(scayt_customDictionaryIds);
        return this;
    }
    public Config scaytCustomerid(String scayt_customerid) {
        setScayt_customerid(scayt_customerid);
        return this;
    }
    public Config scaytMaxSuggestions(Integer scayt_maxSuggestions) {
        setScayt_maxSuggestions(scayt_maxSuggestions);
        return this;
    }
    public Config scaytMoreSuggestions(String scayt_moreSuggestions) {
        setScayt_moreSuggestions(scayt_moreSuggestions);
        return this;
    }
    public Config scaytSLang(String scayt_sLang) {
        setScayt_sLang(scayt_sLang);
        return this;
    }
    public Config scaytSrcUrl(String scayt_srcUrl) {
        setScayt_srcUrl(scayt_srcUrl);
        return this;
    }
    public Config scaytUiTabs(String scayt_uiTabs) {
        setScayt_uiTabs(scayt_uiTabs);
        return this;
    }
    public Config scaytUserDictionaryName(String scayt_userDictionaryName) {
        setScayt_userDictionaryName(scayt_userDictionaryName);
        return this;
    }
    public Config sharedSpaces(SharedSpaces sharedSpaces) {
        setSharedSpaces(sharedSpaces);
        return this;
    }
    public Config shiftEnterMode(EnterMode shiftEnterMode) {
        setShiftEnterMode(shiftEnterMode.getValue());
        return this;
    }
    public Config skin(String skin) {
        setSkin(skin);
        return this;
    }
    public Config smileyColumns(Integer smiley_columns) {
        setSmiley_columns(smiley_columns);
        return this;
    }
    public Config smileyDescriptions(String[] smiley_descriptions) {
        setSmiley_descriptions(smiley_descriptions);
        return this;
    }
    public Config smileyImages(String[] smiley_images) {
        setSmiley_images(smiley_images);
        return this;
    }
    public Config smileyPath(String smiley_path) {
        setSmiley_path(smiley_path);
        return this;
    }
    public Config specialChars(String[] specialChars) {
        setSpecialChars(specialChars);
        return this;
    }
    public Config startupFocus(Boolean startupFocus) {
        setStartupFocus(startupFocus);
        return this;
    }
    public Config startupMode(String startupMode) {
        setStartupMode(startupMode);
        return this;
    }
    public Config startupOutlineBlocks(Boolean startupOutlineBlocks) {
        setStartupOutlineBlocks(startupOutlineBlocks);
        return this;
    }
    public Config startupShowBorders(Boolean startupShowBorders) {
        setStartupShowBorders(startupShowBorders);
        return this;
    }
    public Config stylesheetParserSkipSelectors(String stylesheetParser_skipSelectors) {
        setStylesheetParser_skipSelectors(stylesheetParser_skipSelectors);
        return this;
    }
    public Config stylesheetParserValidSelectors(String stylesheetParser_validSelectors) {
        setStylesheetParser_validSelectors(stylesheetParser_validSelectors);
        return this;
    }
    public Config stylesSet(String stylesSet) {
        setStylesSet(stylesSet);
        return this;
    }
    public Config tabIndex(Integer tabIndex) {
        setTabIndex(tabIndex);
        return this;
    }
    public Config tabSpaces(Integer tabSpaces) {
        setTabSpaces(tabSpaces);
        return this;
    }
    public Config templatesFiles(Integer templates_files) {
        setTemplates_files(templates_files);
        return this;
    }
    public Config templatesReplaceContent(Boolean templates_replaceContent) {
        setTemplates_replaceContent(templates_replaceContent);
        return this;
    }
    public Config theme(String theme) {
        setTheme(theme);
        return this;
    }
    public Config toolbar(Toolbar toolbar) {
        if(this.toolbar == null)
            this.toolbar = new Vector<ToolbarButtonGroup>();
        this.toolbar.addAll(toolbar.getToolbarButtonGroups());
        return this;
    }
    public Config toolbarCanCollapse(Boolean toolbarCanCollapse) {
        setToolbarCanCollapse(toolbarCanCollapse);
        return this;
    }
    public Config toolbarGroupCycling(Boolean toolbarGroupCycling) {
        setToolbarGroupCycling(toolbarGroupCycling);
        return this;
    }
    public Config toolbarLocation(String toolbarLocation) {
        setToolbarLocation(toolbarLocation);
        return this;
    }
    public Config toolbarStartupExpanded(Boolean toolbarStartupExpanded) {
        setToolbarStartupExpanded(toolbarStartupExpanded);
        return this;
    }
    public Config uiColor(String uiColor) {
        setUiColor(uiColor);
        return this;
    }
    public Config undoStackSize(Integer undoStackSize) {
        setUndoStackSize(undoStackSize);
        return this;
    }
    public Config useComputedState(Boolean useComputedState) {
        setUseComputedState(useComputedState);
        return this;
    }
    public Config width(String width) {
        setWidth(width);
        return this;
    }



    /*  END */

    public Integer getAutoGrow_bottomSpace() {
        return autoGrow_bottomSpace;
    }

    private void setAutoGrow_bottomSpace(Integer autoGrow_bottomSpace) {
        this.autoGrow_bottomSpace = autoGrow_bottomSpace;
    }

    public Integer getAutoGrow_maxHeight() {
        return autoGrow_maxHeight;
    }

    private void setAutoGrow_maxHeight(Integer autoGrow_maxHeight) {
        this.autoGrow_maxHeight = autoGrow_maxHeight;
    }

    public Integer getAutoGrow_minHeight() {
        return autoGrow_minHeight;
    }

    private void setAutoGrow_minHeight(Integer autoGrow_minHeight) {
        this.autoGrow_minHeight = autoGrow_minHeight;
    }

    public Boolean isAutoGrow_onStartup() {
        return autoGrow_onStartup;
    }

    private void setAutoGrow_onStartup(Boolean autoGrow_onStartup) {
        this.autoGrow_onStartup = autoGrow_onStartup;
    }

    public Boolean isAutoParagraph() {
        return autoParagraph;
    }

    private void setAutoParagraph(Boolean autoParagraph) {
        this.autoParagraph = autoParagraph;
    }

    public Boolean isAutoUpdateElement() {
        return autoUpdateElement;
    }

    private void setAutoUpdateElement(Boolean autoUpdateElement) {
        this.autoUpdateElement = autoUpdateElement;
    }

    public Integer getBaseFloatZIndex() {
        return baseFloatZIndex;
    }

    private void setBaseFloatZIndex(Integer baseFloatZIndex) {
        this.baseFloatZIndex = baseFloatZIndex;
    }

    public String getBaseHref() {
        return baseHref;
    }

    private void setBaseHref(String baseHref) {
        this.baseHref = baseHref;
    }

    public Boolean isBasicEntities() {
        return basicEntities;
    }

    private void setBasicEntities(Boolean basicEntities) {
        this.basicEntities = basicEntities;
    }

    public String[] getBlockedKeystrokes() {
        return blockedKeystrokes;
    }

    private void setBlockedKeystrokes(String[] blockedKeystrokes) {
        this.blockedKeystrokes = blockedKeystrokes;
    }

    public String getBodyClass() {
        return bodyClass;
    }

    private void setBodyClass(String bodyClass) {
        this.bodyClass = bodyClass;
    }

    public String getBodyId() {
        return bodyId;
    }

    private void setBodyId(String bodyId) {
        this.bodyId = bodyId;
    }

    public Boolean isBrowserContextMenuOnCtrl() {
        return browserContextMenuOnCtrl;
    }

    private void setBrowserContextMenuOnCtrl(Boolean browserContextMenuOnCtrl) {
        this.browserContextMenuOnCtrl = browserContextMenuOnCtrl;
    }

    public BasicStyle getColorButton_backStyle() {
        return colorButton_backStyle;
    }

    private void setColorButton_backStyle(BasicStyle colorButton_backStyle) {
        this.colorButton_backStyle = colorButton_backStyle;
    }

    public String getColorButton_colors() {
        return colorButton_colors;
    }

    private void setColorButton_colors(String colorButton_colors) {
        this.colorButton_colors = colorButton_colors;
    }

    public Boolean isColorButton_enableMore() {
        return colorButton_enableMore;
    }

    private void setColorButton_enableMore(Boolean colorButton_enableMore) {
        this.colorButton_enableMore = colorButton_enableMore;
    }

    public BasicStyle getColorButton_foreStyle() {
        return colorButton_foreStyle;
    }

    private void setColorButton_foreStyle(BasicStyle colorButton_foreStyle) {
        this.colorButton_foreStyle = colorButton_foreStyle;
    }

    public String[] getContentsCss() {
        return contentsCss;
    }

    private void setContentsCss(String[] contentsCss) {
        this.contentsCss = contentsCss;
    }

    public String getContentsLangDirection() {
        return contentsLangDirection;
    }

    private void setContentsLangDirection(String contentsLangDirection) {
        this.contentsLangDirection = contentsLangDirection;
    }

    public String getContentsLanguage() {
        return contentsLanguage;
    }

    private void setContentsLanguage(String contentsLanguage) {
        this.contentsLanguage = contentsLanguage;
    }

    public String getCorePlugins() {
        return corePlugins;
    }

    private void setCorePlugins(String corePlugins) {
        this.corePlugins = corePlugins;
    }

    public InlineStyleOverride getCoreStyles_bold() {
        return coreStyles_bold;
    }

    private void setCoreStyles_bold(InlineStyleOverride coreStyles_bold) {
        this.coreStyles_bold = coreStyles_bold;
    }

    public InlineStyleOverride getCoreStyles_italic() {
        return coreStyles_italic;
    }

    private void setCoreStyles_italic(InlineStyleOverride coreStyles_italic) {
        this.coreStyles_italic = coreStyles_italic;
    }

    public InlineStyleOverride getCoreStyles_strike() {
        return coreStyles_strike;
    }

    private void setCoreStyles_strike(InlineStyleOverride coreStyles_strike) {
        this.coreStyles_strike = coreStyles_strike;
    }

    public InlineStyleOverride getCoreStyles_subscript() {
        return coreStyles_subscript;
    }

    private void setCoreStyles_subscript(InlineStyleOverride coreStyles_subscript) {
        this.coreStyles_subscript = coreStyles_subscript;
    }

    public InlineStyleOverride getCoreStyles_superscript() {
        return coreStyles_superscript;
    }

    private void setCoreStyles_superscript(InlineStyleOverride coreStyles_superscript) {
        this.coreStyles_superscript = coreStyles_superscript;
    }

    public InlineStyleOverride getCoreStyles_underline() {
        return coreStyles_underline;
    }

    private void setCoreStyles_underline(InlineStyleOverride coreStyles_underline) {
        this.coreStyles_underline = coreStyles_underline;
    }

    public String getCustomConfig() {
        return customConfig;
    }

    private void setCustomConfig(String customConfig) {
        this.customConfig = customConfig;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    private void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getDevtools_styles() {
        return devtools_styles;
    }

    private void setDevtools_styles(String devtools_styles) {
        this.devtools_styles = devtools_styles;
    }

    public String getDialog_backgroundCoverColor() {
        return dialog_backgroundCoverColor;
    }

    private void setDialog_backgroundCoverColor(String dialog_backgroundCoverColor) {
        this.dialog_backgroundCoverColor = dialog_backgroundCoverColor;
    }

    public Integer getDialog_backgroundCoverOpacity() {
        return dialog_backgroundCoverOpacity;
    }

    private void setDialog_backgroundCoverOpacity(Integer dialog_backgroundCoverOpacity) {
        this.dialog_backgroundCoverOpacity = dialog_backgroundCoverOpacity;
    }

    public String getDialog_buttonsOrder() {
        return dialog_buttonsOrder;
    }

    private void setDialog_buttonsOrder(String dialog_buttonsOrder) {
        this.dialog_buttonsOrder = dialog_buttonsOrder;
    }

    public Integer getDialog_magnetDistance() {
        return dialog_magnetDistance;
    }

    private void setDialog_magnetDistance(Integer dialog_magnetDistance) {
        this.dialog_magnetDistance = dialog_magnetDistance;
    }

    public Boolean isDialog_startupFocusTab() {
        return dialog_startupFocusTab;
    }

    private void setDialog_startupFocusTab(Boolean dialog_startupFocusTab) {
        this.dialog_startupFocusTab = dialog_startupFocusTab;
    }

    public Boolean isDisableNativeSpellChecker() {
        return disableNativeSpellChecker;
    }

    private void setDisableNativeSpellChecker(Boolean disableNativeSpellChecker) {
        this.disableNativeSpellChecker = disableNativeSpellChecker;
    }

    public Boolean isDisableNativeTableHandles() {
        return disableNativeTableHandles;
    }

    private void setDisableNativeTableHandles(Boolean disableNativeTableHandles) {
        this.disableNativeTableHandles = disableNativeTableHandles;
    }

    public Boolean isDisableObjectResizing() {
        return disableObjectResizing;
    }

    private void setDisableObjectResizing(Boolean disableObjectResizing) {
        this.disableObjectResizing = disableObjectResizing;
    }

    public Boolean isDisableReadonlyStyling() {
        return disableReadonlyStyling;
    }

    private void setDisableReadonlyStyling(Boolean disableReadonlyStyling) {
        this.disableReadonlyStyling = disableReadonlyStyling;
    }

    public String getDocType() {
        return docType;
    }

    private void setDocType(String docType) {
        this.docType = docType;
    }

    public Boolean isEditingBlock() {
        return editingBlock;
    }

    private void setEditingBlock(Boolean editingBlock) {
        this.editingBlock = editingBlock;
    }

    public String getEmailProtection() {
        return emailProtection;
    }

    private void setEmailProtection(String emailProtection) {
        this.emailProtection = emailProtection;
    }

    public Boolean isEnableTabKeyTools() {
        return enableTabKeyTools;
    }

    private void setEnableTabKeyTools(Boolean enableTabKeyTools) {
        this.enableTabKeyTools = enableTabKeyTools;
    }

    public Integer getEnterMode() {
        return enterMode;
    }

    private void setEnterMode(Integer enterMode) {
        this.enterMode = enterMode;
    }

    public Boolean isEntities() {
        return entities;
    }

    private void setEntities(Boolean entities) {
        this.entities = entities;
    }

    public String getEntities_additional() {
        return entities_additional;
    }

    private void setEntities_additional(String entities_additional) {
        this.entities_additional = entities_additional;
    }

    public Boolean isEntities_greek() {
        return entities_greek;
    }

    private void setEntities_greek(Boolean entities_greek) {
        this.entities_greek = entities_greek;
    }

    public Boolean isEntities_latin() {
        return entities_latin;
    }

    private void setEntities_latin(Boolean entities_latin) {
        this.entities_latin = entities_latin;
    }

    public Boolean isEntities_processNumerical() {
        return entities_processNumerical;
    }

    private void setEntities_processNumerical(Boolean entities_processNumerical) {
        this.entities_processNumerical = entities_processNumerical;
    }

    public String getExtraPlugins() {
        return extraPlugins;
    }

    private void setExtraPlugins(String extraPlugins) {
        this.extraPlugins = extraPlugins;
    }

    public String getFilebrowserBrowseUrl() {
        return filebrowserBrowseUrl;
    }

    private void setFilebrowserBrowseUrl(String filebrowserBrowseUrl) {
        this.filebrowserBrowseUrl = filebrowserBrowseUrl;
    }

    public String getFilebrowserFlashBrowseUrl() {
        return filebrowserFlashBrowseUrl;
    }

    private void setFilebrowserFlashBrowseUrl(String filebrowserFlashBrowseUrl) {
        this.filebrowserFlashBrowseUrl = filebrowserFlashBrowseUrl;
    }

    public String getFilebrowserFlashUploadUrl() {
        return filebrowserFlashUploadUrl;
    }

    private void setFilebrowserFlashUploadUrl(String filebrowserFlashUploadUrl) {
        this.filebrowserFlashUploadUrl = filebrowserFlashUploadUrl;
    }

    public String getFilebrowserImageBrowseLinkUrl() {
        return filebrowserImageBrowseLinkUrl;
    }

    private void setFilebrowserImageBrowseLinkUrl(String filebrowserImageBrowseLinkUrl) {
        this.filebrowserImageBrowseLinkUrl = filebrowserImageBrowseLinkUrl;
    }

    public String getFilebrowserImageBrowseUrl() {
        return filebrowserImageBrowseUrl;
    }

    private void setFilebrowserImageBrowseUrl(String filebrowserImageBrowseUrl) {
        this.filebrowserImageBrowseUrl = filebrowserImageBrowseUrl;
    }

    public String getFilebrowserImageUploadUrl() {
        return filebrowserImageUploadUrl;
    }

    private void setFilebrowserImageUploadUrl(String filebrowserImageUploadUrl) {
        this.filebrowserImageUploadUrl = filebrowserImageUploadUrl;
    }

    public String getFilebrowserUploadUrl() {
        return filebrowserUploadUrl;
    }

    private void setFilebrowserUploadUrl(String filebrowserUploadUrl) {
        this.filebrowserUploadUrl = filebrowserUploadUrl;
    }

    public String getFilebrowserWindowFeatures() {
        return filebrowserWindowFeatures;
    }

    private void setFilebrowserWindowFeatures(String filebrowserWindowFeatures) {
        this.filebrowserWindowFeatures = filebrowserWindowFeatures;
    }

    public String getFilebrowserWindowHeight() {
        return filebrowserWindowHeight;
    }

    private void setFilebrowserWindowHeight(String filebrowserWindowHeight) {
        this.filebrowserWindowHeight = filebrowserWindowHeight;
    }

    public String getFilebrowserWindowWidth() {
        return filebrowserWindowWidth;
    }

    private void setFilebrowserWindowWidth(String filebrowserWindowWidth) {
        this.filebrowserWindowWidth = filebrowserWindowWidth;
    }

    public Boolean isFillEmptyBlocks() {
        return fillEmptyBlocks;
    }

    private void setFillEmptyBlocks(Boolean fillEmptyBlocks) {
        this.fillEmptyBlocks = fillEmptyBlocks;
    }

    public BasicStyle getFind_highlight() {
        return find_highlight;
    }

    private void setFind_highlight(BasicStyle find_highlight) {
        this.find_highlight = find_highlight;
    }

    public String getFont_defaultLabel() {
        return font_defaultLabel;
    }

    private void setFont_defaultLabel(String font_defaultLabel) {
        this.font_defaultLabel = font_defaultLabel;
    }

    public String getFont_names() {
        return font_names;
    }

    private void setFont_names(String font_names) {
        this.font_names = font_names;
    }

    public BasicStyleOverride getFont_style() {
        return font_style;
    }

    private void setFont_style(BasicStyleOverride font_style) {
        this.font_style = font_style;
    }

    public String getFontSize_defaultLabel() {
        return fontSize_defaultLabel;
    }

    private void setFontSize_defaultLabel(String fontSize_defaultLabel) {
        this.fontSize_defaultLabel = fontSize_defaultLabel;
    }

    public String getFontSize_sizes() {
        return fontSize_sizes;
    }

    private void setFontSize_sizes(String fontSize_sizes) {
        this.fontSize_sizes = fontSize_sizes;
    }

    public BasicStyleOverride getFontSize_style() {
        return fontSize_style;
    }

    private void setFontSize_style(BasicStyleOverride fontSize_style) {
        this.fontSize_style = fontSize_style;
    }

    public Boolean isForceEnterMode() {
        return forceEnterMode;
    }

    private void setForceEnterMode(Boolean forceEnterMode) {
        this.forceEnterMode = forceEnterMode;
    }

    public Boolean isForcePasteAsPlainText() {
        return forcePasteAsPlainText;
    }

    private void setForcePasteAsPlainText(Boolean forcePasteAsPlainText) {
        this.forcePasteAsPlainText = forcePasteAsPlainText;
    }

    public Boolean isForceSimpleAmpersand() {
        return forceSimpleAmpersand;
    }

    private void setForceSimpleAmpersand(Boolean forceSimpleAmpersand) {
        this.forceSimpleAmpersand = forceSimpleAmpersand;
    }

    public InlineStyle getFormat_address() {
        return format_address;
    }

    private void setFormat_address(InlineStyle format_address) {
        this.format_address = format_address;
    }

    public InlineStyle getFormat_div() {
        return format_div;
    }

    private void setFormat_div(InlineStyle format_div) {
        this.format_div = format_div;
    }

    public InlineStyle getFormat_h1() {
        return format_h1;
    }

    private void setFormat_h1(InlineStyle format_h1) {
        this.format_h1 = format_h1;
    }

    public InlineStyle getFormat_h2() {
        return format_h2;
    }

    private void setFormat_h2(InlineStyle format_h2) {
        this.format_h2 = format_h2;
    }

    public InlineStyle getFormat_h3() {
        return format_h3;
    }

    private void setFormat_h3(InlineStyle format_h3) {
        this.format_h3 = format_h3;
    }

    public InlineStyle getFormat_h4() {
        return format_h4;
    }

    private void setFormat_h4(InlineStyle format_h4) {
        this.format_h4 = format_h4;
    }

    public InlineStyle getFormat_h5() {
        return format_h5;
    }

    private void setFormat_h5(InlineStyle format_h5) {
        this.format_h5 = format_h5;
    }

    public InlineStyle getFormat_h6() {
        return format_h6;
    }

    private void setFormat_h6(InlineStyle format_h6) {
        this.format_h6 = format_h6;
    }

    public InlineStyle getFormat_p() {
        return format_p;
    }

    private void setFormat_p(InlineStyle format_p) {
        this.format_p = format_p;
    }

    public InlineStyle getFormat_pre() {
        return format_pre;
    }

    private void setFormat_pre(InlineStyle format_pre) {
        this.format_pre = format_pre;
    }

    public String getFormat_tags() {
        return format_tags;
    }

    private void setFormat_tags(String format_tags) {
        this.format_tags = format_tags;
    }

    public Boolean isFullPage() {
        return fullPage;
    }

    private void setFullPage(Boolean fullPage) {
        this.fullPage = fullPage;
    }

    public String getHeight() {
        return height;
    }

    private void setHeight(String height) {
        this.height = height;
    }

    public Boolean isHtmlEncodeOutput() {
        return htmlEncodeOutput;
    }

    private void setHtmlEncodeOutput(Boolean htmlEncodeOutput) {
        this.htmlEncodeOutput = htmlEncodeOutput;
    }

    public Boolean isIgnoreEmptyParagraph() {
        return ignoreEmptyParagraph;
    }

    private void setIgnoreEmptyParagraph(Boolean ignoreEmptyParagraph) {
        this.ignoreEmptyParagraph = ignoreEmptyParagraph;
    }

    public String getImage_previewText() {
        return image_previewText;
    }

    private void setImage_previewText(String image_previewText) {
        this.image_previewText = image_previewText;
    }

    public Boolean isImage_removeLinkByEmptyURL() {
        return image_removeLinkByEmptyURL;
    }

    private void setImage_removeLinkByEmptyURL(Boolean image_removeLinkByEmptyURL) {
        this.image_removeLinkByEmptyURL = image_removeLinkByEmptyURL;
    }

    public String[] getIndentClasses() {
        return indentClasses;
    }

    private void setIndentClasses(String[] indentClasses) {
        this.indentClasses = indentClasses;
    }

    public Integer getIndentOffset() {
        return indentOffset;
    }

    private void setIndentOffset(Integer indentOffset) {
        this.indentOffset = indentOffset;
    }

    public String getIndentUnit() {
        return indentUnit;
    }

    private void setIndentUnit(String indentUnit) {
        this.indentUnit = indentUnit;
    }

    public Boolean isJqueryOverrideVal() {
        return jqueryOverrideVal;
    }

    private void setJqueryOverrideVal(Boolean jqueryOverrideVal) {
        this.jqueryOverrideVal = jqueryOverrideVal;
    }

    public String[] getJustifyClasses() {
        return justifyClasses;
    }

    private void setJustifyClasses(String[] justifyClasses) {
        this.justifyClasses = justifyClasses;
    }

    public String[] getKeystrokes() {
        return keystrokes;
    }

    private void setKeystrokes(String[] keystrokes) {
        this.keystrokes = keystrokes;
    }

    public String getLanguage() {
        return language;
    }

    private void setLanguage(String language) {
        this.language = language;
    }

    public String getMenu_groups() {
        return menu_groups;
    }

    private void setMenu_groups(String menu_groups) {
        this.menu_groups = menu_groups;
    }

    public String getNewpage_html() {
        return newpage_html;
    }

    private void setNewpage_html(String newpage_html) {
        this.newpage_html = newpage_html;
    }

    public String getPasteFromWordCleanupFile() {
        return pasteFromWordCleanupFile;
    }

    private void setPasteFromWordCleanupFile(String pasteFromWordCleanupFile) {
        this.pasteFromWordCleanupFile = pasteFromWordCleanupFile;
    }

    public Boolean isPasteFromWordNumberedHeadingToList() {
        return pasteFromWordNumberedHeadingToList;
    }

    private void setPasteFromWordNumberedHeadingToList(Boolean pasteFromWordNumberedHeadingToList) {
        this.pasteFromWordNumberedHeadingToList = pasteFromWordNumberedHeadingToList;
    }

    public Boolean isPasteFromWordPromptCleanup() {
        return pasteFromWordPromptCleanup;
    }

    private void setPasteFromWordPromptCleanup(Boolean pasteFromWordPromptCleanup) {
        this.pasteFromWordPromptCleanup = pasteFromWordPromptCleanup;
    }

    public Boolean isPasteFromWordRemoveFontStyles() {
        return pasteFromWordRemoveFontStyles;
    }

    private void setPasteFromWordRemoveFontStyles(Boolean pasteFromWordRemoveFontStyles) {
        this.pasteFromWordRemoveFontStyles = pasteFromWordRemoveFontStyles;
    }

    public Boolean isPasteFromWordRemoveStyles() {
        return pasteFromWordRemoveStyles;
    }

    private void setPasteFromWordRemoveStyles(Boolean pasteFromWordRemoveStyles) {
        this.pasteFromWordRemoveStyles = pasteFromWordRemoveStyles;
    }

    public String getPlugins() {
        return plugins;
    }

    private void setPlugins(String plugins) {
        this.plugins = plugins;
    }

    public String[] getProtectedSource() {
        return protectedSource;
    }

    private void setProtectedSource(String[] protectedSource) {
        this.protectedSource = protectedSource;
    }

    public Boolean isReadOnly() {
        return readOnly;
    }

    private void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getRemoveDialogTabs() {
        return removeDialogTabs;
    }

    private void setRemoveDialogTabs(String removeDialogTabs) {
        this.removeDialogTabs = removeDialogTabs;
    }

    public String getRemoveFormatAttributes() {
        return removeFormatAttributes;
    }

    private void setRemoveFormatAttributes(String removeFormatAttributes) {
        this.removeFormatAttributes = removeFormatAttributes;
    }

    public String getRemoveFormatTags() {
        return removeFormatTags;
    }

    private void setRemoveFormatTags(String removeFormatTags) {
        this.removeFormatTags = removeFormatTags;
    }

    public String getRemovePlugins() {
        return removePlugins;
    }

    private void setRemovePlugins(String removePlugins) {
        this.removePlugins = removePlugins;
    }

    public String getResize_dir() {
        return resize_dir;
    }

    private void setResize_dir(String resize_dir) {
        this.resize_dir = resize_dir;
    }

    public Boolean isResize_enabled() {
        return resize_enabled;
    }

    private void setResize_enabled(Boolean resize_enabled) {
        this.resize_enabled = resize_enabled;
    }

    public Integer getResize_maxHeight() {
        return resize_maxHeight;
    }

    private void setResize_maxHeight(Integer resize_maxHeight) {
        this.resize_maxHeight = resize_maxHeight;
    }

    public Integer getResize_maxWidth() {
        return resize_maxWidth;
    }

    private void setResize_maxWidth(Integer resize_maxWidth) {
        this.resize_maxWidth = resize_maxWidth;
    }

    public Integer getResize_minHeight() {
        return resize_minHeight;
    }

    private void setResize_minHeight(Integer resize_minHeight) {
        this.resize_minHeight = resize_minHeight;
    }

    public Integer getResize_minWidth() {
        return resize_minWidth;
    }

    private void setResize_minWidth(Integer resize_minWidth) {
        this.resize_minWidth = resize_minWidth;
    }

    public Boolean isScayt_autoStartup() {
        return scayt_autoStartup;
    }

    private void setScayt_autoStartup(Boolean scayt_autoStartup) {
        this.scayt_autoStartup = scayt_autoStartup;
    }

    public String getScayt_contextCommands() {
        return scayt_contextCommands;
    }

    private void setScayt_contextCommands(String scayt_contextCommands) {
        this.scayt_contextCommands = scayt_contextCommands;
    }

    public String getScayt_contextMenuItemsOrder() {
        return scayt_contextMenuItemsOrder;
    }

    private void setScayt_contextMenuItemsOrder(String scayt_contextMenuItemsOrder) {
        this.scayt_contextMenuItemsOrder = scayt_contextMenuItemsOrder;
    }

    public String getScayt_customDictionaryIds() {
        return scayt_customDictionaryIds;
    }

    private void setScayt_customDictionaryIds(String scayt_customDictionaryIds) {
        this.scayt_customDictionaryIds = scayt_customDictionaryIds;
    }

    public String getScayt_customerid() {
        return scayt_customerid;
    }

    private void setScayt_customerid(String scayt_customerid) {
        this.scayt_customerid = scayt_customerid;
    }

    public Integer getScayt_maxSuggestions() {
        return scayt_maxSuggestions;
    }

    private void setScayt_maxSuggestions(Integer scayt_maxSuggestions) {
        this.scayt_maxSuggestions = scayt_maxSuggestions;
    }

    public String getScayt_moreSuggestions() {
        return scayt_moreSuggestions;
    }

    private void setScayt_moreSuggestions(String scayt_moreSuggestions) {
        this.scayt_moreSuggestions = scayt_moreSuggestions;
    }

    public String getScayt_sLang() {
        return scayt_sLang;
    }

    private void setScayt_sLang(String scayt_sLang) {
        this.scayt_sLang = scayt_sLang;
    }

    public String getScayt_srcUrl() {
        return scayt_srcUrl;
    }

    private void setScayt_srcUrl(String scayt_srcUrl) {
        this.scayt_srcUrl = scayt_srcUrl;
    }

    public String getScayt_uiTabs() {
        return scayt_uiTabs;
    }

    private void setScayt_uiTabs(String scayt_uiTabs) {
        this.scayt_uiTabs = scayt_uiTabs;
    }

    public String getScayt_userDictionaryName() {
        return scayt_userDictionaryName;
    }

    private void setScayt_userDictionaryName(String scayt_userDictionaryName) {
        this.scayt_userDictionaryName = scayt_userDictionaryName;
    }

    public SharedSpaces getSharedSpaces() {
        return sharedSpaces;
    }

    private void setSharedSpaces(SharedSpaces sharedSpaces) {
        this.sharedSpaces = sharedSpaces;
    }

    public Integer getShiftEnterMode() {
        return shiftEnterMode;
    }

    private void setShiftEnterMode(Integer shiftEnterMode) {
        this.shiftEnterMode = shiftEnterMode;
    }

    public String getSkin() {
        return skin;
    }

    private void setSkin(String skin) {
        this.skin = skin;
    }

    public Integer getSmiley_columns() {
        return smiley_columns;
    }

    private void setSmiley_columns(Integer smiley_columns) {
        this.smiley_columns = smiley_columns;
    }

    public String[] getSmiley_descriptions() {
        return smiley_descriptions;
    }

    private void setSmiley_descriptions(String[] smiley_descriptions) {
        this.smiley_descriptions = smiley_descriptions;
    }

    public String[] getSmiley_images() {
        return smiley_images;
    }

    private void setSmiley_images(String[] smiley_images) {
        this.smiley_images = smiley_images;
    }

    public String getSmiley_path() {
        return smiley_path;
    }

    private void setSmiley_path(String smiley_path) {
        this.smiley_path = smiley_path;
    }

    public String[] getSpecialChars() {
        return specialChars;
    }

    private void setSpecialChars(String[] specialChars) {
        this.specialChars = specialChars;
    }

    public Boolean isStartupFocus() {
        return startupFocus;
    }

    private void setStartupFocus(Boolean startupFocus) {
        this.startupFocus = startupFocus;
    }

    public String getStartupMode() {
        return startupMode;
    }

    private void setStartupMode(String startupMode) {
        this.startupMode = startupMode;
    }

    public Boolean isStartupOutlineBlocks() {
        return startupOutlineBlocks;
    }

    private void setStartupOutlineBlocks(Boolean startupOutlineBlocks) {
        this.startupOutlineBlocks = startupOutlineBlocks;
    }

    public Boolean isStartupShowBorders() {
        return startupShowBorders;
    }

    private void setStartupShowBorders(Boolean startupShowBorders) {
        this.startupShowBorders = startupShowBorders;
    }

    public String getStylesheetParser_skipSelectors() {
        return stylesheetParser_skipSelectors;
    }

    private void setStylesheetParser_skipSelectors(String stylesheetParser_skipSelectors) {
        this.stylesheetParser_skipSelectors = stylesheetParser_skipSelectors;
    }

    public String getStylesheetParser_validSelectors() {
        return stylesheetParser_validSelectors;
    }

    private void setStylesheetParser_validSelectors(String stylesheetParser_validSelectors) {
        this.stylesheetParser_validSelectors = stylesheetParser_validSelectors;
    }

    public String getStylesSet() {
        return stylesSet;
    }

    private void setStylesSet(String stylesSet) {
        this.stylesSet = stylesSet;
    }

    public Integer getTabIndex() {
        return tabIndex;
    }

    private void setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
    }

    public Integer getTabSpaces() {
        return tabSpaces;
    }

    private void setTabSpaces(Integer tabSpaces) {
        this.tabSpaces = tabSpaces;
    }

    public Integer getTemplates_files() {
        return templates_files;
    }

    private void setTemplates_files(Integer templates_files) {
        this.templates_files = templates_files;
    }

    public Boolean isTemplates_replaceContent() {
        return templates_replaceContent;
    }

    private void setTemplates_replaceContent(Boolean templates_replaceContent) {
        this.templates_replaceContent = templates_replaceContent;
    }

    public String getTheme() {
        return theme;
    }

    private void setTheme(String theme) {
        this.theme = theme;
    }

    public List<ToolbarButtonGroup> getToolbar() {
        return toolbar;
    }

    public Boolean isToolbarCanCollapse() {
        return toolbarCanCollapse;
    }

    private void setToolbarCanCollapse(Boolean toolbarCanCollapse) {
        this.toolbarCanCollapse = toolbarCanCollapse;
    }

    public Boolean isToolbarGroupCycling() {
        return toolbarGroupCycling;
    }

    private void setToolbarGroupCycling(Boolean toolbarGroupCycling) {
        this.toolbarGroupCycling = toolbarGroupCycling;
    }

    public String getToolbarLocation() {
        return toolbarLocation;
    }

    private void setToolbarLocation(String toolbarLocation) {
        this.toolbarLocation = toolbarLocation;
    }

    public Boolean isToolbarStartupExpanded() {
        return toolbarStartupExpanded;
    }

    private void setToolbarStartupExpanded(Boolean toolbarStartupExpanded) {
        this.toolbarStartupExpanded = toolbarStartupExpanded;
    }

    public String getUiColor() {
        return uiColor;
    }

    private void setUiColor(String uiColor) {
        this.uiColor = uiColor;
    }

    public Integer getUndoStackSize() {
        return undoStackSize;
    }

    private void setUndoStackSize(Integer undoStackSize) {
        this.undoStackSize = undoStackSize;
    }

    public Boolean isUseComputedState() {
        return useComputedState;
    }

    private void setUseComputedState(Boolean useComputedState) {
        this.useComputedState = useComputedState;
    }

    public String getWidth() {
        return width;
    }

    private void setWidth(String width) {
        this.width = width;
    }
}
