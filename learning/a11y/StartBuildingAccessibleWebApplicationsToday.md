# Start Building Accessible Web Applications Today

## 01. Accessible Icon Buttons

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

- By aria-lablledby for SVG  

AS-IS
```
		<div class="button" role="button" tabindex="0">
			<svg width="32" height="32" viewBox="0 0 32 32" class="icon" aria-labelledby="svgtitle">
				<title id="svgtitle">Help!</title>
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

## 02. Accessible Button Events

- with Button tag [1]
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

- with div tag [1]
AS-IS
```
		<div class="button" role="button" tabindex="0" aria-label="Menu">
			<i class="icon icon-menu"></i>
		</div>
```	
TO-BE
```
		<div class="button" role="button" tabindex="0" aria-label="Menu" ng-click="doStuff()" ng-keydown="doStuff()">
			<i class="icon icon-menu"></i>
		</div>
```	

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

- For `input` tag
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

- input and label
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

- input group title
AS-IS
```
<p>Favorite animal</p>
```

TO-BE
```
<fieldset>
	<legend>Favorite animal</legend>
	...
</fieldset>
```

## 04. Headings and semantic structure for accessible web pages

## 05. Focus management using CSS, HTML, and JavaScript

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

[2]: JS
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

## 06. What is the Accessibility Tree?
	
## 07. Intro to ARIA

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
## 09. Using the Voiceover screen reader to test for accessibility
## 10. Testing for Accessibility with the NVDA Screen Reader on Windows
## 11. Creating visual skip links in HTML and CSS
## 12. Accessible modal dialogs
## 13. Using the tabindex attribute for keyboard accessibility
