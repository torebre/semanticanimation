@file:JsQualifier("MathJax")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package MathJax

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Callback {
    @nativeInvoke
    operator fun invoke(fn: Function<*>): CallbackObject
    @nativeInvoke
    operator fun invoke(fns: Array<Function<*>>): CallbackObject
    @nativeInvoke
    operator fun invoke(objs: Array<Any>): CallbackObject
    @nativeInvoke
    operator fun invoke(obj: Any): CallbackObject
    @nativeInvoke
    operator fun invoke(code: String): CallbackObject
    fun Delay(time: Number, callback: Any): CallbackObject
    fun Queue(vararg args: Any): Queue
    fun Signal(name: String): Signal
    fun ExecuteHooks(hooks: Array<Any>, data: Array<Any>, reset: Boolean): CallbackObject
    fun Hooks(reset: Boolean): Hooks

    companion object : Callback by definedExternally
}

external interface Hooks {
    fun Add(hook: Any, priority: Number): CallbackObject
    fun Remove(hook: CallbackObject)
    fun Execute(): CallbackObject
}

external interface Queue {
    var pending: Number
    var running: Number
    var queue: Array<Any>
    fun Push(specs: Array<Any>): CallbackObject
    fun Process()
    fun Suspend()
    fun Resume()
    fun wait(callback: Function<*>): Function<*>
    fun call()
}

external interface Signal {
    var name: String
    var posted: Array<Any>
    var listeners: Array<CallbackObject>
    fun Post(message: String): CallbackObject
    fun Post(message: String, callback: CallbackObject): CallbackObject
    fun Clear(): CallbackObject
    fun Clear(callback: CallbackObject): CallbackObject
    fun Interest(callback: CallbackObject): CallbackObject
    fun Interest(callback: CallbackObject, ignorePast: Boolean): CallbackObject
    fun NoInterest(callback: CallbackObject)
    fun MessageHook(message: String, callback: CallbackObject): CallbackObject
    fun ExecuteHook(message: String)
}

external interface CallbackObject {
    var hook: Number
    var data: Array<Any>
    var `object`: Any
    var called: Boolean
    var autoReset: Boolean
    fun reset()
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Hub {
    var config: Config?
        get() = definedExternally
        set(value) = definedExternally
    var processSectionDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var processUpdateTime: Number?
        get() = definedExternally
        set(value) = definedExternally
    var processUpdateDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var signal: Signal?
        get() = definedExternally
        set(value) = definedExternally
    var queue: Any?
        get() = definedExternally
        set(value) = definedExternally
    var Browser: BrowserInfo?
        get() = definedExternally
        set(value) = definedExternally
    var inputJax: Any?
        get() = definedExternally
        set(value) = definedExternally
    var outputJax: Any?
        get() = definedExternally
        set(value) = definedExternally
    var Register: Register?
        get() = definedExternally
        set(value) = definedExternally
    fun Config(config: Config)
    fun Configured()
    fun Queue(callBack: Any): Any
    fun Typeset(element: Any, callBack: Any): Any
    fun PreProcess(element: Any, callBack: Any): Any
    fun Process(element: Any, callBack: Any): Any
    fun Update(element: Any, callBack: Any): Any
    fun Reprocess(element: Any, callBack: Any): Any
    fun Rerender(element: Any, callBack: Any): Any
    fun getAllJax(element: Any): Array<Any>
    fun getJaxByType(type: String, element: Any)
    fun getJaxByInputType(type: String, element: Any)
    fun getJaxFor(element: Any): Any
    fun isJax(element: Any): Number
    fun setRenderer(renderer: String, type: String)
    fun Insert(dst: Any, src: Any): Any
    fun formatError(script: Any, error: Any)

    companion object : Hub by definedExternally
}

external interface Register {
    fun PreProcessor(callBack: Any)
    fun MessageHook(type: String, callBack: Any)
    fun StartupHook(type: String, callBack: Any)
    fun LoadHook(file: String, callBack: Function<*>)
}

external interface BrowserInfo {
    var version: String
    var isMac: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isPC: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isMobile: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isFirefox: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isSafari: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isChrome: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isOpera: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isMSIE: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isKonqueror: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    fun versionAtLeast(version: String)
    fun Select(choices: Any)
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Ajax {
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var STATUS: STATUS
    var loaded: Any
    var loading: Boolean
    var loadHooks: Any
    fun Require(file: String, callBack: Any): Any
    fun Load(file: String, callBack: Any): Any
    fun loadComplete(file: String)
    fun loadTimeout(file: String)
    fun loadError(file: String)
    fun LoadHook(file: String, callBack: Any): Any
    fun Preloading(vararg args: Any)
    fun Styles(styles: Any, callback: Any): Any
    fun fileURL(file: String): String

    companion object : Ajax by definedExternally
}

external interface STATUS {
    var OK: String
    var ERROR: String
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Message {
    fun Set(message: String, n: Number, delay: Number): Number
    fun Clear(n: Number, delay: Number)
    fun Remove()
    fun File(file: String): Number
    fun filterText(text: String, n: Number): String
    fun Log(): String

    companion object : Message by definedExternally
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface HTML {
    var Cookie: Cookie?
        get() = definedExternally
        set(value) = definedExternally
    fun Element(type: String, attributes: Any, contents: Any): Any
    fun addElement(parent: Any, type: String, attributes: Any, content: Any): Any
    fun TextNode(text: String): Any
    fun addText(parent: Any, text: String): Any
    fun setScript(script: String, text: String)
    fun getScript(script: String): String

    companion object : HTML by definedExternally
}

external interface Cookie {
    var prefix: String?
        get() = definedExternally
        set(value) = definedExternally
    var expires: Number?
        get() = definedExternally
        set(value) = definedExternally
    fun Set(name: String, data: Any)
    fun Get(name: String): Any
    fun Get(name: String, obj: Any): Any
}

external interface MenuSettings {
    var zoom: String?
        get() = definedExternally
        set(value) = definedExternally
    var CTRL: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ALT: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var CMD: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var Shift: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var zscale: String?
        get() = definedExternally
        set(value) = definedExternally
    var context: String?
        get() = definedExternally
        set(value) = definedExternally
    var texHints: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var mpContext: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var mpMouse: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var renderer: String? /* "HTML-CSS" | "CommonHTML" | "PreviewHTML" | "NativeMML" | "SVG" | "PlainSource" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface ErrorSettings {
    var message: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var style: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Config {
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: HTMLCSSOutputProcessor?)
    @nativeSetter
    operator fun set(key: String, value: Boolean?)
    var MathZoom: MathZoom?
        get() = definedExternally
        set(value) = definedExternally
    var MathMenu: MathMenu?
        get() = definedExternally
        set(value) = definedExternally
    var MathEvents: MathEvents?
        get() = definedExternally
        set(value) = definedExternally
    var FontWarnings: FontWarnings?
        get() = definedExternally
        set(value) = definedExternally
    var Safe: Safe?
        get() = definedExternally
        set(value) = definedExternally
    var MatchWebFonts: MatchWebFonts?
        get() = definedExternally
        set(value) = definedExternally
    var SVG: SVGOutputProcessor?
        get() = definedExternally
        set(value) = definedExternally
    var MMLorHTML: MMLorHTMLConfiguration?
        get() = definedExternally
        set(value) = definedExternally
    var NativeMML: NativeMMLOutputProcessor?
        get() = definedExternally
        set(value) = definedExternally
    var CommonHTML: CommonHTMLOutputProcessor?
        get() = definedExternally
        set(value) = definedExternally
    var AsciiMath: AsciiMathInputProcessor?
        get() = definedExternally
        set(value) = definedExternally
    var MathML: MathMLInputProcessor?
        get() = definedExternally
        set(value) = definedExternally
    var TeX: TeXInputProcessor?
        get() = definedExternally
        set(value) = definedExternally
    var jsMath2jax: JSMath2jaxPreprocessor?
        get() = definedExternally
        set(value) = definedExternally
    var asciimath2jax: Asciimath2jaxPreprocessor?
        get() = definedExternally
        set(value) = definedExternally
    var mml2jax: MML2jaxPreprocessor?
        get() = definedExternally
        set(value) = definedExternally
    var tex2jax: TEX2jaxPreprocessor?
        get() = definedExternally
        set(value) = definedExternally
    var jax: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var extensions: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var config: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var styleSheets: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var styles: Any?
        get() = definedExternally
        set(value) = definedExternally
    var preJax: Any?
        get() = definedExternally
        set(value) = definedExternally
    var postJax: Any?
        get() = definedExternally
        set(value) = definedExternally
    var preRemoveClass: String?
        get() = definedExternally
        set(value) = definedExternally
    var showProcessingMessages: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var messageStyle: String?
        get() = definedExternally
        set(value) = definedExternally
    var displayAlign: String?
        get() = definedExternally
        set(value) = definedExternally
    var displayIndent: String?
        get() = definedExternally
        set(value) = definedExternally
    var delayStartupUntil: String?
        get() = definedExternally
        set(value) = definedExternally
    var skipStartupTypeset: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var elements: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var positionToHash: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showMathMenu: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showMathMenuMSIE: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var menuSettings: MenuSettings?
        get() = definedExternally
        set(value) = definedExternally
    var errorSettings: ErrorSettings?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MathZoom {
    var styles: Any
}

external interface MathMenu {
    var delay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var helpURL: String?
        get() = definedExternally
        set(value) = definedExternally
    var showRenderer: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showFontMenu: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showLocale: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showMathPlayer: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showContext: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var semanticsAnnotations: Any?
        get() = definedExternally
        set(value) = definedExternally
    var windowSettings: Any?
        get() = definedExternally
        set(value) = definedExternally
    var styles: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MathEvents {
    var hover: Number?
        get() = definedExternally
        set(value) = definedExternally
    var styles: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FontWarnings {
    var messageStyle: Any?
        get() = definedExternally
        set(value) = definedExternally
    var Message: HTMLMessages?
        get() = definedExternally
        set(value) = definedExternally
    var HTML: HTMLSnippets?
        get() = definedExternally
        set(value) = definedExternally
    var removeAfter: Number?
        get() = definedExternally
        set(value) = definedExternally
    var fadeoutSteps: Number?
        get() = definedExternally
        set(value) = definedExternally
    var fadeoutTime: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface HTMLMessages {
    var webFont: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
    var imageFonts: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
    var noFonts: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface HTMLSnippets {
    var closeBox: String?
        get() = definedExternally
        set(value) = definedExternally
    var webfonts: String?
        get() = definedExternally
        set(value) = definedExternally
    var fonts: String?
        get() = definedExternally
        set(value) = definedExternally
    var STIXfonts: String?
        get() = definedExternally
        set(value) = definedExternally
    var TeXfonts: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Safe {
    var allow: SafeAllow?
        get() = definedExternally
        set(value) = definedExternally
    var sizeMin: Number?
        get() = definedExternally
        set(value) = definedExternally
    var sizeMax: Number?
        get() = definedExternally
        set(value) = definedExternally
    var safeProtocols: SafeProtocols?
        get() = definedExternally
        set(value) = definedExternally
    var safeStyles: SafeStyles?
        get() = definedExternally
        set(value) = definedExternally
    var safeRequire: SafeRequire?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SafeAllow {
    var URLs: String?
        get() = definedExternally
        set(value) = definedExternally
    var classes: String?
        get() = definedExternally
        set(value) = definedExternally
    var cssIDs: String?
        get() = definedExternally
        set(value) = definedExternally
    var styles: String?
        get() = definedExternally
        set(value) = definedExternally
    var require: String?
        get() = definedExternally
        set(value) = definedExternally
    var fontsize: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SafeProtocols {
    var http: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var https: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var file: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var javascript: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SafeStyles {
    var color: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var backgroundColor: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var border: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var cursor: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var margin: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var padding: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var textShadow: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var fontFamily: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var fontSize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var fontStyle: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var fontWeight: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var opacity: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var outline: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SafeRequire {
    @nativeGetter
    operator fun get(key: String): Boolean?
    @nativeSetter
    operator fun set(key: String, value: Boolean?)
    var action: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var amscd: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var amsmath: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var amssymbols: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var autobold: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var bbox: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var begingroup: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var boldsymbol: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var cancel: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var color: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var enclose: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var extpfeil: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var HTML: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var mathchoice: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var mhchem: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var newcommand: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var noErrors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var noUndefined: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var unicode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var verb: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MatchWebFonts {
    var matchFor: MatchFor?
        get() = definedExternally
        set(value) = definedExternally
    var fontCheckDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var fontCheckTimeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MatchFor {
    @nativeGetter
    operator fun get(key: String): Boolean?
    @nativeSetter
    operator fun set(key: String, value: Boolean?)
    var NativeMML: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var SVG: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SVGOutputProcessor {
    var scale: Number?
        get() = definedExternally
        set(value) = definedExternally
    var minScaleAdjust: Number?
        get() = definedExternally
        set(value) = definedExternally
    var font: String?
        get() = definedExternally
        set(value) = definedExternally
    var blacker: Number?
        get() = definedExternally
        set(value) = definedExternally
    var undefinedFamily: String?
        get() = definedExternally
        set(value) = definedExternally
    var mtextFontInherit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var addMMLclasses: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var useFontCache: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var useGlobalCache: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var EqnChunk: Number?
        get() = definedExternally
        set(value) = definedExternally
    var EqnChunkFactor: Number?
        get() = definedExternally
        set(value) = definedExternally
    var EqnChunkDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var matchFontHeight: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var linebreaks: LineBreaks?
        get() = definedExternally
        set(value) = definedExternally
    var styles: Any?
        get() = definedExternally
        set(value) = definedExternally
    var tooltip: ToolTip?
        get() = definedExternally
        set(value) = definedExternally
}

external interface LineBreaks {
    var automatic: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var width: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ToolTip {
    var delayPost: Number
    var delayClear: Number
    var offsetX: Number
    var offsetY: Number
}

external interface MMLorHTMLConfiguration {
    var prefer: BrowserPreference?
        get() = definedExternally
        set(value) = definedExternally
}

external interface BrowserPreference {
    var MSIE: String?
        get() = definedExternally
        set(value) = definedExternally
    var Firefox: String?
        get() = definedExternally
        set(value) = definedExternally
    var Safari: String?
        get() = definedExternally
        set(value) = definedExternally
    var Chrome: String?
        get() = definedExternally
        set(value) = definedExternally
    var Opera: String?
        get() = definedExternally
        set(value) = definedExternally
    var other: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface NativeMMLOutputProcessor {
    var scale: Number?
        get() = definedExternally
        set(value) = definedExternally
    var minScaleAdjust: Number?
        get() = definedExternally
        set(value) = definedExternally
    var matchFontHeight: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var styles: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface HTMLCSSOutputProcessor {
    var scale: Number?
        get() = definedExternally
        set(value) = definedExternally
    var minScaleAdjust: Number?
        get() = definedExternally
        set(value) = definedExternally
    var availableFonts: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var preferredFont: String?
        get() = definedExternally
        set(value) = definedExternally
    var webFont: String?
        get() = definedExternally
        set(value) = definedExternally
    var imageFont: String?
        get() = definedExternally
        set(value) = definedExternally
    var undefinedFamily: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var mtextFontInherit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var EqnChunk: Number?
        get() = definedExternally
        set(value) = definedExternally
    var EqnChunkFactor: Number?
        get() = definedExternally
        set(value) = definedExternally
    var EqnChunkDelay: Number?
        get() = definedExternally
        set(value) = definedExternally
    var matchFontHeight: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var linebreaks: LineBreaks?
        get() = definedExternally
        set(value) = definedExternally
    var styles: Any?
        get() = definedExternally
        set(value) = definedExternally
    var showMathMenu: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var tooltip: ToolTip?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CommonHTMLOutputProcessor {
    var scale: Number?
        get() = definedExternally
        set(value) = definedExternally
    var minScaleAdjust: Number?
        get() = definedExternally
        set(value) = definedExternally
    var mtextFontInherit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var linebreaks: LineBreaks?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AsciiMathInputProcessor {
    var displaystyle: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var decimal: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MathMLInputProcessor {
    var useMathMLspacing: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TeXInputProcessor {
    var TagSide: String?
        get() = definedExternally
        set(value) = definedExternally
    var TagIndent: String?
        get() = definedExternally
        set(value) = definedExternally
    var MultLineWidth: String?
        get() = definedExternally
        set(value) = definedExternally
    var equationNumbers: EquationNumbers?
        get() = definedExternally
        set(value) = definedExternally
    var Macros: Any?
        get() = definedExternally
        set(value) = definedExternally
    var MAXMACROS: Number?
        get() = definedExternally
        set(value) = definedExternally
    var MAXBUFFER: Number?
        get() = definedExternally
        set(value) = definedExternally
    var extensions: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EquationNumbers {
    var autoNumber: String?
        get() = definedExternally
        set(value) = definedExternally
    var formatNumber: ((n: Number) -> String)?
        get() = definedExternally
        set(value) = definedExternally
    var formatTag: ((n: Number) -> String)?
        get() = definedExternally
        set(value) = definedExternally
    var formatID: (() -> String)?
        get() = definedExternally
        set(value) = definedExternally
    var formatURL: ((id: String) -> String)?
        get() = definedExternally
        set(value) = definedExternally
    var useLabelIds: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface JSMath2jaxPreprocessor {
    var preview: Any
}

external interface Asciimath2jaxPreprocessor {
    var delimiters: Any?
        get() = definedExternally
        set(value) = definedExternally
    var preview: Any?
        get() = definedExternally
        set(value) = definedExternally
    var skipTags: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreClass: String?
        get() = definedExternally
        set(value) = definedExternally
    var processClass: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MML2jaxPreprocessor {
    var preview: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TEX2jaxPreprocessor {
    var inlineMath: Any?
        get() = definedExternally
        set(value) = definedExternally
    var displayMath: Any?
        get() = definedExternally
        set(value) = definedExternally
    var balanceBraces: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var processEscapes: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var processEnvironments: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var preview: Any?
        get() = definedExternally
        set(value) = definedExternally
    var skipTags: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreClass: String?
        get() = definedExternally
        set(value) = definedExternally
    var processClass: String?
        get() = definedExternally
        set(value) = definedExternally
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Localization {
    var locale: String
    var directory: String
    var strings: Any
    fun `_`(id: Number, message: String, vararg args: Any)
    fun setLocale(locale: String)
    fun addTranslation(locale: String, domain: String, def: Any)
    fun setCSS(div: Any): Any
    fun fontFamily(): String
    fun fontDirection(): String
    fun plural(value: Any): Number
    fun number(value: Number): String
    fun loadDomain(domain: String): CallbackObject
    fun loadDomain(domain: String, callback: CallbackObject): CallbackObject
    fun Try(spec: Any)

    companion object : Localization by definedExternally
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface InputJax {
    var id: String
    var version: String
    var directory: String
    var elementJax: String
    fun Process(script: Any, state: Any): Any
    fun Translate(script: Any, state: Any): ElementJax
    fun Register(mimetype: String)
    fun needsUpdate(element: Any): Boolean

    companion object : InputJax by definedExternally
}

@Suppress("EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface OutputJax {
    var id: String
    var version: String
    var directory: String
    var fontDir: String
    var imageDir: String
    fun preProcess(state: Any)
    fun preTranslate(state: Any)
    fun Translate(script: Any, state: Any): ElementJax
    fun postTranslate(state: Any)
    fun Register(mimetype: String)
    fun Remove(jax: Any)
    fun getJaxFromMath(math: Any): ElementJax
    fun Zoom(jax: Any, span: Any, math: Any, Mw: Number, Mh: Number): ZoomStruct

    companion object : OutputJax by definedExternally
}

external interface ZoomStruct {
    var Y: Number
    var mW: Number
    var mH: Number
    var zW: Number
    var zH: Number
}

external interface ElementJax {
    var id: String
    var version: String
    var directory: String
    var inputJax: String
    var outputJax: String
    var inputID: String
    var originalText: String
    var mimeType: String
    fun Text(text: String): CallbackObject
    fun Text(text: String, callback: Any): CallbackObject
    fun Rerender(callback: Any): CallbackObject
    fun Reprocess(callback: Any): CallbackObject
    fun Remove()
    fun SourceElement(): Any
    fun needsUpdate(): Boolean
}