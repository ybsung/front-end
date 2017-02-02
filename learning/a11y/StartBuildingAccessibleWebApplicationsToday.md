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
## 03. Building Forms with Accessibility in Mind
## 04. Headings and semantic structure for accessible web pages
## 05. Focus management using CSS, HTML, and JavaScript
## 06. What is the Accessibility Tree?
## 07. Intro to ARIA
## 08. How Visible vs. Hidden Elements Affect Keyboard/Screen Reader Users
## 09. Using the Voiceover screen reader to test for accessibility
## 10. Testing for Accessibility with the NVDA Screen Reader on Windows
## 11. Creating visual skip links in HTML and CSS
## 12. Accessible modal dialogs
## 13. Using the tabindex attribute for keyboard accessibility
