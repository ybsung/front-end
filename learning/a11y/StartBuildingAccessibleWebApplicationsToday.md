# Start Building Accessible Web Applications Today (Egghead.io)

This repo contains notes from [Marcy Sutton](https://egghead.io/instructors/marcy-sutton)'s accessibility course on Egghead.io  
https://egghead.io/courses/start-building-accessible-web-applications-today

## 01. Accessible Icon Buttons

: How to create accessible buttons using HTML and CSS

- Example

```
<button>Help!</button>
```

- By span tag  

AS-IS
```
<button>
	<i class="icon icon-help"></i>
</button>
```

TO-BE
```
/* To be hidden visually */
.visuallyhidden { 
	border: 0;
	clip: rect(0 0 0 0);
	height: 1px;
	margin: -1px;
	overflow: hidden;
	padding: 0;
	position: absolute;
	width: 1px;
}

<button>
	<span class="visuallyhidden">Help!</span>
	<i class="icon icon-help" aria-hidden="true"></i>
</button>
```
1. Add a `span` element and a visually hidden class in it
2. Add `area-hidden="true"` in `i` element

- By aria-label attribute  

AS-IS
```
<button>
	<i class="icon icon-help"></i>
</button>
```

TO-BE
```
<button aria-label="Help!">
	<i class="icon icon-help" aria-hidden="true"></i>
</button>
```
1. Add `aria-label` in `button`
2. Add `aria-hidden="true"` in `i`

- By aria-lablledby for SVG  

AS-IS
```
<div class="button">
	<svg width="32" height="32" viewBox="0 0 32 32" class="icon">
		<path d="M14 24h4v-4h-4v4zM16 8c-3 0-6 3-6 6h4c0-1 1-2 2-2s2 1 2 2c0 2-4 2-4 4h4c2-0.688 4-2 4-5s-3-5-6-5zM16 0c-8.844 0-16 7.156-16 16s7.156 16 16 16 16-7.156 16-16-7.156-16-16-16zM16 28c-6.625 0-12-5.375-12-12s5.375-12 12-12 12 5.375 12 12-5.375 12-12 12z"></path>
	</svg>
</div>
```

TO-BE
```
<div class="button" role="button" tabindex="0">
	<svg width="32" height="32" viewBox="0 0 32 32" class="icon" aria-labelledby="svgtitle">
		<title id="svgtitle">Help!</title>
		<path d="M14 24h4v-4h-4v4zM16 8c-3 0-6 3-6 6h4c0-1 1-2 2-2s2 1 2 2c0 2-4 2-4 4h4c2-0.688 4-2 4-5s-3-5-6-5zM16 0c-8.844 0-16 7.156-16 16s7.156 16 16 16 16-7.156 16-16-7.156-16-16-16zM16 28c-6.625 0-12-5.375-12-12s5.375-12 12-12 12 5.375 12 12-5.375 12-12 12z"></path>
	</svg>
</div>
```
1. Add `role` and `tabindex` in `div` element
2. Add `title` element as the first child in `svg` element
3. Add `aria-labelledby`  in `svg` element.

* `aria-labelledby="svgtitle"` is needed now because of Chrome bug. But it could be fixed later.

## 02. Accessible Button Events

: How we make buttons work from keyboard

- With `button` tag [1]

AS-IS
```
<button aria-label="Help">
	<i class="icon icon-help"></i>
</button>
```

TO-BE
```
<button aria-label="Help" ng-click="doStuff()">
	<i class="icon icon-help"></i>
</button>
```
1. To work : Add `ng-click` in Angular 1  in `button` element


- With `div` tag [1]

AS-IS
```
<div class="button">
	<i class="icon icon-menu"></i>
</div>
```

TO-BE
```
<div class="button" role="button" tabindex="0" aria-label="Menu" ng-click="doStuff()" ng-keydown="doStuff()">
	<i class="icon icon-menu"></i>
</div>
```
1. To be accessible : Add `role`, `tabindex`, `aria-label` in `div` element
2. To work : Add `ng-click`, `ng-keydown` in `div` element

[1]: JS code
```
angular.module('demoApp', [])
.controller('demoController', function($scope) {
  $scope.doStuff = function($event){
  	alert('do stuff');
  };
});
```

## 03. Building Forms with Accessibility in Mind

: How to create more accessible forms 

- Implicit labeling

: In case that `input` element and its label are sibling elements

AS-IS
```
Your name
<input type="text">
<div>
	<input type="radio" name="animals">
	Dog
</div>
<div>
	<input type="radio" name="animals">
	Cat
</div>
<div>
	<input type="radio" name="animals">
	Polar bear
</div>
```
Problem 1: When clicking on `Your name`, the `input` could not get focus
Problem 2: When clicking any label of radio `input`, the input could not get focus

TO-BE
```
<label>
	Your name
	<input type="text">
</label>
<div>
	<label>
		<input type="radio" name="animals">
		Dog
	</label>
</div>
<div>
	<label>
		<input type="radio" name="animals">
		Cat
	</label>
</div>
<div>
	<label>
		<input type="radio" name="animals">
		Polar bear
	</label>
</div>
```
1. Wrap the text and the inputs in a `label` element (implicit labeling)

- Explicit labeling

:In case that `input` and its label have different parent.

AS-IS
```
<div class="label-wrap">
	<label>
		Hometown
	</label>
</div>
<div class="input-wrap">
	<input type="text">
</div>
```

TO-BE
```
<div class="label-wrap">
	<label for="hometown">
		Hometown
	</label>
</div>
<div class="input-wrap">
	<input type="text" id="hometown">
</div>
```

- Form group title

AS-IS
```
<p>Favorite animal</p>
```
Problem : The form group title is not readable.

TO-BE
```
<fieldset>
	<legend>Favorite animal</legend>
	...
</fieldset>
```

## 04. Headings and semantic structure for accessible web pages

## 05. Focus management using CSS, HTML, and JavaScript

- Not ever dropping focus or leaving them in the wrong context as new things appear

JS
```
$(document).ready(function() {
	var list = $('ul'),
		listItems = list.find('li');

	$('.btn-delete').on('click', function() {
		$(this).parent().remove();
		listItems.find('.btn-delete').first().focus();
	});
});
```

- Easier to navigate with skip links

AS-IS
```
  <header role="banner">
  	<h1>Focus Management</h1>
  </header>
  <main role="main">
  	<h2>Main content</h2>
  	...
  </main>
  <footer role="contentinfo">
	...
  </footer>
```

TO-BE
```
  <ul class="skip-links">
    <li><a href="#main">Main content</a></li>
    <li><a href="#footer">Global footer</a></li>
  </ul>
  <header role="banner">
  	<h1>Focus Management</h1>
  </header>
  <main role="main" id="main" tabindex="-1">
  	<h2>Main content</h2>
  	...
  </main>
  <footer role="contentinfo" id="footer" tabindex="-1">
	...
  </footer>
```

[1]: CSS
```
/* Only for tabindex is negative */
[tabindex="-1"] {
	outline: 0;
}
ul.skip-links {
	list-style: none;
	position: absolute;
}
ul.skip-links a {
	background-color: #fff;
	display: block;
	left: -999999px;
	padding: 1em;
	position: absolute;
}
ul.skip-links a:focus {
	left: 0;
}
```

## 06. What is the Accessibility Tree?

: How to look at the accessibility tree

### Chrome browser
#### `Accessibility` tab in chrome insepctor Element's panel
https://egghead.io/lessons/html-5-what-is-the-accessibility-tree#/ at 00:50 in Video

#### `Accessibility tree`  
chrome://accessibility  
It would be a huge performance problem to be building and showing this tree all the time.  
https://egghead.io/lessons/html-5-what-is-the-accessibility-tree#/ at 01:40 in Video  

### Edge
#### `Accessibility tree` tab in Edge DOM explorer  
https://egghead.io/lessons/html-5-what-is-the-accessibility-tree#/ at 02:53 in Video  

## 07. Intro to ARIA

: Accessible rich Internet applications, or WAI-ARIA

### Role
- What an element does
- Don't use abstract roles
- Use the widget roles

### native element vs custom element
- button tag

```
<!-- native buttons submit forms by default -->
<!-- use type="button" to stop that behavior -->
<button disabled>button</button>
```

- custom button

```
custom-button[aria-disabled="true"] {
	color: graytext;
	pointer-events: false;
}

<!-- this custom button won't submit a form without JavaScript, a major winning point of the native button -->
<custom-button role="button" tabindex="0" aria-label="Close" aria-disabled="true"></custom-button>
```

## 08. How Visible vs. Hidden Elements Affect Keyboard/Screen Reader Users

```
<div style="display: none;">
	<h1>Heading</h1>
	<a href="#link1">Link 1</a>
</div>
<!--
	 To hide something from everybody, your keyboard and screen reader users included,
	 use `display: none`.
-->

<div hidden>
	<h1>Heading</h1>
	<a href="#link2">Link 2</a>
</div>
<!--
	 To hide something from everybody, your keyboard and screen reader users included,
	 use `display: none`.
	 Supported in quite a few browsers
-->

<div style="opacity: 0;">
	<h1>Heading</h1>
	<a href="#link3">Link 3</a>
</div>
<!--
	 To reserve the dimensions of the div
	 To hide the content
	 To be focusable
	: Useful for animation
-->

<div style="visibility: hidden;">
	<h1>Heading</h1>
	<a href="#link4">Link 4</a>
</div>
<!--
	 To reserve the dimensions of the div
	 To hide the content
	 To be not focusable
	: Useful for the disabled button in a toolbar
-->

/* from the HTML5 Boilerplate */
.visuallyhidden { 
	border: 0;
	clip: rect(0 0 0 0);
	height: 1px;
	margin: -1px;
	overflow: hidden;
	padding: 0;
	position: absolute;
	width: 1px;
}

<div class="visuallyhidden">
	<h1>Heading</h1>
	<a href="#link5">Link 5</a>
</div>
<!--
	 To hide on the screen
	 To be focusable
	 : Useful for text alternatives
-->

<div aria-hidden="true">
	<h1>Heading</h1>
	<a href="#link6">Link 6</a>
</div>
	 To show on the screen
	 : To disable it from a screen reader user
	 : Needed to add this tab index of negative one ( `aria-hidden` will cascade. But `tab-index` will not cascade )
	 : Usefull for dialog
```

## 09. Using the Voiceover screen reader to test for accessibility

: Learn the basics for operating Voiceover with Safari

Resources
Apple Voiceover commands and gestures: https://www.apple.com/voiceover/info/guide/_1131.html
WebAIM Voiceover Tutorial: http://webaim.org/articles/voiceover/

## 10. Testing for Accessibility with the NVDA Screen Reader on Windows

NVDA is a popular open source screen reader on Windows that works well with Firefox.

### Resources

- Using NVDA to Emulate Web Accessibility : http://webaim.org/articles/nvda/
- NVDA Keyboard Shortcuts : https://dequeuniversity.com/screenreaders/nvda-keyboard-shortcuts
- Understanding Screen Reader Interaction Modes : http://tink.uk/understanding-screen-reader-interaction-modes/
- Three Things You Should Know Before Using Voiceover for Testing : http://webaim.org/blog/three-things-voiceover/

### Installing NVDA

If you're on a Windows machine, you can install NVDA directly. If you're on a Mac or Linux, you could install a Windows virtual machine:
- Install VirtualBox : https://www.virtualbox.org/wiki/Downloads
- Get a Windows VM from Microsoft - I use IE11 : https://developer.microsoft.com/en-us/microsoft-edge/tools/vms/
- Install Firefox - install on the VM! : https://www.mozilla.org/en-US/firefox/new/
- Install NVDA : https://www.nvaccess.org/download/
- How to Map Your Mac's Capslock Key to a NVDA or JAWS Key in a Windows VM : https://www.marcozehe.de/2015/06/07/how-to-map-your-macs-capslock-key-to-a-nvda-or-jaws-key-in-a-windows-virtual-machine/

## 11. Creating visual skip links in HTML and CSS

AS-IS
```
<ul>
	<li><a href="#global-nav">Skip to navigation</a></li>
	<li><a href="#main">Skip to content</a></li>
	<li><a href="#footer">Skip to footer</a></li>
</ul>
<header role="banner" id="global-nav" tabindex="-1">
</header>
<main role="main" id="main" tabindex="-1">
	<h1>Homepage</h1>
	<h2><a href="#">Article Title</a></h2>
</main>
<footer role="contentinfo" id="footer" tabindex="-1">

</footer>
```
Code : at 02:10 in https://egghead.io/lessons/css-creating-visual-skip-links-in-html-and-css#/
Output : at 02:17 in https://egghead.io/lessons/css-creating-visual-skip-links-in-html-and-css#/

TO-BE
```
.skip-links {
	list-style: none;
	margin: 0;
	padding: 0;
	position: relative;
}
.skip-links li a {
	background-color: #fff;
	display: block;
	left: -600000px;
	padding: 0.5em;
	position: absolute;
}
.skip-links li a:focus {
	left: 0;
}
[tabindex="-1"]:focus {
	outline: none;
}

<ul class="skip-links">
	<li><a href="#global-nav">Skip to navigation</a></li>
	<li><a href="#main">Skip to content</a></li>
	<li><a href="#footer">Skip to footer</a></li>
</ul>
<header role="banner" id="global-nav" tabindex="-1">

</header>
<main role="main" id="main" tabindex="-1">
	<h1>Homepage</h1>
	<h2><a href="#">Article Title</a></h2>
</main>
<footer role="contentinfo" id="footer" tabindex="-1">

</footer>
```
Output : at 02:43 in https://egghead.io/lessons/css-creating-visual-skip-links-in-html-and-css#/

## 12. Accessible modal dialogs

AS-IS
```
<ul class="skip-links">
	<li><a href="#global-nav">Skip to navigation</a></li>
	<li><a href="#main">Skip to content</a></li>
	<li><a href="#footer">Skip to footer</a></li>
</ul>
<header role="banner" id="global-nav" tabindex="-1">

</header>
<main role="main" id="main" tabindex="-1">
	<h1>Homepage</h1>
	<h2><a href="#">Article Title</a></h2>
</main>
<footer role="contentinfo" id="footer" tabindex="-1">

</footer>
```

TO-BE
```
<div class="wrapper">
	<ul class="skip-links">
		<li><a href="#global-nav">Skip to navigation</a></li>
		<li><a href="#main">Skip to content</a></li>
		<li><a href="#footer">Skip to footer</a></li>
	</ul>
	<header role="banner" id="global-nav" tabindex="-1">

	</header>
	<main role="main" id="main" tabindex="-1">
		<h1>Homepage</h1>
		<h2><a href="#">Article Title</a></h2>

		<button id="modalTrigger">Open dialog</button>
	</main>
	<footer role="contentinfo" id="footer" tabindex="-1">

	</footer>
</div>
<dialog role="dialog">
	<h2>Modal dialog</h2>
	<button id="closeBtn">Close</button>
</dialog>

<script src="node_modules/dialog-polyfill/dialog-polyfill.js"></script>
<script src="node_modules/wicg-inert/inert.js"></script>
<script src="script.js"></script>
```

```
document.addEventListener("DOMContentLoaded", pageLoaded);

function pageLoaded(event) { 
	
	var dialogBtn = document.getElementById('dialogTrigger'),
		closeBtn = document.getElementById('closeBtn'),
		dialog = document.querySelector('dialog'),
		wrapper = document.querySelector('.wrapper');

	dialogPolyfill.registerDialog(dialog);

	dialogBtn.addEventListener('click', function() {
		dialog.show();

		wrapper.setAttribute('inert', '');

		document.addEventListener('keydown', handleKeydown);
	});

	closeBtn.addEventListener('click', closeModal);

	function closeModal(event) {
		dialog.close();

		wrapper.removeAttribute('inert');

		setTimeout(function() {
			dialogBtn.focus();
		});

		document.removeEventListener('keydown', handleKeydown);
	}

	function handleKeydown(event) {
		if (event.keyCode === 27) {
			closeModal();
		}
	}
}
```

## 13. Using the tabindex attribute for keyboard accessibility

```
<button id="realBtn" class="btn">Button</button>

<div tabindex="100" id="fakeBtn" class="btn" role="button">Button</div>

document.addEventListener("DOMContentLoaded", pageLoaded);

function pageLoaded() {
	var btn = document.getElementById('fakeBtn');
	btn.addEventListener('click', btnEventHandler);
	btn.addEventListener('keydown', btnEventHandler);
}

function btnEventHandler(event) {
	console.log(event.type);

	var realBtn = document.getElementById('realBtn');
	realBtn.focus();
}
```

# Resources
Use Chrome with accessibility extensions
https://support.google.com/chrome/answer/7040464?hl=en
https://chrome.google.com/webstore/category/collection/accessibility
	Accessibility Developer Tools, chrome extension
	https://chrome.google.com/webstore/detail/accessibility-developer-t/fpkknkljclfencbdbgkenhalefipecmb

Accessibility Tree
chrome://accessibility/

The guide for `Accessibility` in `Elements` panel of Chrome inspector
https://gist.github.com/marcysutton/0a42f815878c159517a55e6652e3b23a


