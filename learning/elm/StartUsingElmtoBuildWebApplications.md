# Start Using Elm to Build Web Applications

This repo contains notes from Murphy Randle's elm course on Egghead.io
https://egghead.io/courses/start-using-elm-to-build-web-applications

## 1. Output text in a browser using the text function in Elm  
  
```
module Main exposing (..)

import Html exposing (text)

main = 
	text "Hello"
```
Result
```
Hello
```

## 2. Install the Elm Platform command-line tools  
  
```
npm install -g elm

elm reactor

elm repl
> foo = 1
> bar = 2
> foo + bar
3 : number
```

## 3. Write functions and Type Signatures in Elm  
  
```
module Main exposing (..)

import Html exposing (text)

ask thing =
	"is there a " ++ thing ++ "?"

main = 
	text <| ask "fish"
```
Result
```
is there a fish?
```

```
ask : String -> String -> String
ask thing place =
	"is there a " 
		++ thing 
		++ " in the " 
		++ place 
		++ "?"

main = 
	text <| ask "fish" "sock"
```
Result
```
is there a fish in the sock?
```

```
politely : String -> String
politely phrase = 
	"Excuse me, " ++ phrase

ask : String -> String -> String
ask thing place =
	"is there a " 
		++ thing 
		++ " in the " 
		++ place 
		++ "?"

main = 
	text
		<| politely
		<| ask "fish" "sock"
```
Result
```
Excuse me, is there a fish in the sock?
```

```
politely : String -> String
politely phrase = 
	"Excuse me, " ++ phrase

ask : String -> String -> String
ask thing place =
	"is there a " 
		++ thing 
		++ " in the " 
		++ place 
		++ "?"

askPolitelyAboutFish : String -> String
askPolitelyAboutFish = politely << (ask "fish")

main = 
	text <| askPolitelyAboutFish "hat"
```
Result
```
Excuse me, is there a fish in the hat?
```

## 4. Store key-value pairs using Records in Elm  
  
```
dog =
	{ name = "Spock"
	, age = 3
	}
main = 
	text <| toString <| .age dog
```
Result
```
3
```

```
type alias Dog =
	{ name : String
	, age : Int
	}

dog =
	{ name = "Spock"
	, age = 3
	}

renderDog : Dog -> String
renderDog dog =
	dog.name ++ ", " ++ (toString dog.age)
main = 
	text <| renderDog dog
```
Result
```
Spock, 3
```

## 5. Sequencing Data With Lists in Elm  

```
type alias Person =
	{ name : String
	, age : Int
	}

people =
	[ { name = "Legolas", age = 2931 }
	, { name = "Gimli", age = 139 }
	]

name : List Person -> List String
names peeps = List.map(\peep -> peep.name) peeps

findPerson : String -> List Person -> Maybe
	Person
findPerson name peeps =
	List.foldl
		(\peep memo ->
			case memo of 
	 			Just _ ->
	 				memo

	 			Nothing ->
	 				if peep.name = name then
						Just peep
					else
					Nothing
		)
		Nothing
		peeps

main =
	text <| toString <| findPerson "Legolas"
```
Result
```
Just { name="Legolas", age =2931 }
```

## 6. Render HTML in the browser using the Html module in Elm  
  
```
type alias ship =
	{ name : String
	, model : String
	, cost : Int
	}

ships = 
	[ { name = "X-wing", cost = 149999 }
	, { name = "Millennium Falcon", cost = 100000 }
	, { name = "Death Star", cost = 100000000 }
	]

main =
	text <| toString <| ships
```
Result
```
[{name="X-wing",cost=149999},{name="Millennium Falcon",cost=100000},{name="Death Star",cost=100000000}]
```

```
type alias ship =
	{ name : String
	, model : String
	, cost : Int
	}

ships = 
	[ { name = "X-wing", cost = 149999 }
	, { name = "Millennium Falcon", cost = 100000 }
	, { name = "Death Star", cost = 100000000 }
	]

renderShip ship =
	li []
		[ text ship.name
		, text ", "
		, b []
			[ text <| toString ship.cost]
		]

renderShips ships = 
	div
		[ style
			[( "(font-family", "-apple-system" )
			, ( "padding", "1em" )
			]
		]
		[ h1 [] [text "Ships"]
		, ul [] (List.map renderShip ships)
		] 

main = renderShips ships
```
Result
2:42 at https://egghead.io/lessons/elm-render-html-in-the-browser-using-the-html-module-in-elm
```
Ships
- X-wing, 149999
- Millennium Falcon, 100000
- Death Star, 100000000
```

## 7. Reuse Functions Through Type Variables in Elm  
  
```
numbers =
	[ 1, 2, 3, 4, 5]

printNumbers : thing -> Html msg
printNumbers thing =
	ul [] [ text <| toString int ]

fruits =
	[ { name = "Orange" }, { name = "Banana" } ]

main =
	ul [] (List.map printThing numbers)
```
Result
```
1
2
3
4
5
```

```
main =
	ul [] (List.map printThing fruits)
```
Result
```
 { name = "Orange" }
 { name = "Banana" }
```

## 8. Create Apps Using the Elm Application Architecture  
  
```
view = 
	div []
		[ h1 [] [ text "Face generator" ]
		]

main = 
	view
```
Result
```
Face generator
```

```

model =
	{ showFace = False }

type Msg =
	ShowFace

update msg model_ = 
	case msg of
		ShowFace -> { model_ | showFace = True}
view model _= 
	div []
		[ h1 [] [ text "Face generator" ]
		, button [ onClick ShowFace ] [ text "Face me" ]
		, if model_.showFace then
			text "(^___^)"
		  else
		  	text ""
		]

main = 
	beginnerProgram
		{ model = model
		, update = update
		, view = view
		}
```
Result
4:40 at https://egghead.io/lessons/elm-create-apps-using-the-elm-application-architecture
```
Face generator

Face me (^___^)
```

## 9. Discover New Packages Using the Elm Package Index  
  
```
items = 
	[ "Green Eggs", "Green Ham" ]

main = 
	div []
		[ h1 [] [ text <| "Item" ]
		, text <| toString <| items
		]
```
Result
```
Items
["Green Eggs", "Green Ham"]

```

elm-package install NoRedInk/elm-string-extra

```
import String.Extra exposing (pluralize)

items = 
	[ "Green Eggs" ]

main = 
	div []
		[ h1 []
			[ text <| (pluralize "Item" "Item" (List.length items))
			]
		, text <| toString <| items
		]
```
Result
```
1 Item
["Green Eggs"]

```

# Elm
http://elm-lang.org/

# Links
JavaScript 개발자를 위한 Elm
http://bestalign.github.io/2015/11/28/elm-for-javascript-developers/
