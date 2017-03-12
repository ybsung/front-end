# Fiber 
 
## React Fiber Architecture

https://github.com/acdlite/react-fiber-architecture  

## React - Basic Theoretical Concepts

https://github.com/reactjs/react-basic  

## Thinking in React

https://facebook.github.io/react/docs/thinking-in-react.html  

  * Step 1: Break The UI Into A Component Hierarchy  
    * single responsibility principle: https://en.wikipedia.org/wiki/Single_responsibility_principle
  * Step 2: Build A Static Version in React  
  * Step 3: Identify The Minimal (but complete) Representation Of UI State  
    * Need to think of the minimal set of mutable state  
    * Don't Repeat Yourself  
    * Figure out which one is state  
      * Is it passed in from a parent via props? If so, it probably isn't state.  
      * Does it remain unchanged over time? If so, it probably isn't state.  
      * Can you compute it based on any other state or props in your component? If so, it isn't state.  
  * Step 4: Identify Where Your State Should Live  
    * We need to identify which component mutates, or owns, this state   
      * Identify every component that renders something based on that state.  
      * Find a common owner component (a single component above all the components that need the state in the hierarchy).  
      * Either the common owner or another component higher up in the hierarchy should own the state.  
      * If you can't find a component where it makes sense to own the state, create a new component simply for holding the state and add it somewhere in the hierarchy above the common owner component.  
  * Step 5: Add Inverse Data Flow  
  
## Design Principles : https://facebook.github.io/react/contributing/design-principles.html  
* 

New Core Algorithm : https://github.com/facebook/react/issues/6170  
The features  
https://github.com/facebook/react/issues/7925  
https://github.com/facebook/react/issues/8830  
Video  
Andrew Clark: What's Next for React — ReactNext 2016  
https://www.youtube.com/watch?v=aV1271hd9ew  
How to install React Fiber  
https://devdemand.co/how-to-install-react-fibre/  
