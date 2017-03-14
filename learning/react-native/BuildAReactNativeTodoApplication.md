# Build a React Native Todo Application  
  
## 1. Setup React Native for iOS and Android  
  
## 2. Create the Basic React Native Todo Application Layout  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/layout/todo  
  
header.js  
  * View  
  
footer.js  
  * View  
  
app.js  
  * View  
    * Header  
    * View  
    * Footer  
  * For ios, *padding-top* is needed for indicator  
```
const styles = StyleSheet.create({
  container: {
    backgroundColor: "#F5F5F5",
    ...Platform.select({
      ios: { paddingTop: 30 }
    })
  },
  ...
})
```

index.ios.js  
index.android.js  
```
AppRegistry.registerComponent('todo', () => App);
```

## 3. Create a React Native TextInput  

Repo & branch : https://github.com/browniefed/examples/tree/todo/textinput
Compare : https://github.com/browniefed/examples/compare/todo/layout...todo/textinput

header.js  
  * View  
    * TextInput  
      * value={this.props.value}
      * placeholder="What needs to be done?"
      * blurOnSubmit={false}
      * returnKeyType="done"
      *
      * onChangeText={this.props.onChange}
      * onSubmitEditing={this.props.onAddItem}  
  
app.js  
  * View  
    * Header  
      * value
      * ( onSubmitEditing-> ) onAddItem={this.handleAddItem}  
      * ( onChangeText-> ) onChange={(value) => this.setState({ value })}  
    * View  
    * Footer  

  * handleAddItem 
```
  handleAddItem () => this.setState({
    items:   [
      ...this.state.items,
      {
        key: Date.now(),
        text: this.state.value,
        complete: false
      }
    ],
    value: ""
  });
```

## 4. Add a Toggle All Complete Button with React Native TouchableOpacity  
## 5. Create a List of Items with a React Native ListView  
## 6. Add a Complete Toggle with React Native Switch  
## 7. Add a Remove Item Button to Each Row with React Native TouchableOpacity  
## 8. Filter Items in the React Native List View  
## 9. Add the Total Remaining Item Count to the Footer with React Native Text  
## 10. Add a Clear All Complete Button to the Footer with React Native TouchableOpacity  
## 11. Persist Items with React Native AsyncStorage  
## 12. Add a Loading Indicator While Loading Items with React Native ActivityIndicator  
## 13. Inline Edit Todo Items in a React Native ListView  


## Resources

### Code Snippets

https://gist.github.com/browniefed/abc2460df79d9dbae5421cde951e1ed1

