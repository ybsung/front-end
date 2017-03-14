# Build a React Native Todo Application  
  
This repo contains notes from [Jason Brown](http://browniefed.com)'s React-native course on Egghead.io  
https://egghead.io/courses/build-a-react-native-todo-application  
  
## 1. Setup React Native for iOS and Android  
  
## 2. Create the Basic React Native Todo Application Layout  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/layout/todo  
  
header.js  
  * import { View } from "react-native";  
  * `<View>`  
  
footer.js  
  * `<View>`  
  
app.js  
  * `<View>`  
    * `<Header>`  
    * `<View>`  
    * `<Footer>`  
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
  * import { TextInput } from "react-native";
  * `<View>`  
    * `<TextInput>`  
      * value={this.props.value}  
      * placeholder="What needs to be done?"  
      * blurOnSubmit={false}  
      * returnKeyType="done"  
      *  
      * onChangeText={this.props.onChange}  
      * onSubmitEditing={this.props.onAddItem}  
  
app.js  
  * `<View>`  
    * `<Header>`  
      * value  
      * ( onSubmitEditing-> ) onAddItem={this.handleAddItem}  
      * ( onChangeText-> ) onChange={(value) => this.setState({ value })}  
  
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
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/togglecomplete  
Compare : https://github.com/browniefed/examples/compare/todo/textinput...todo/togglecomplete  
  
header.js  
  * import { Text, TouchableOpacity } from "react-native";  
  * `<View>`  
    * `<TouchableOpacity>`  
      * onPress={this.props.onToggleAllComplete}  
      *  
      * `<Text style={styles.toggleIcon}>{String.fromCharCode(10003)}</Text>`  
  
app.js  
  * `<View>`  
    * `<Header>`  
      * ( onPress-> ) onToggleAllComplete={this.handleToggleAllComplete}  
  
  * handleToggleAllComplete  
```
handleToggleAllComplete() {
  const complete = !this.state.allComplete;
  const newItems = this.state.items.map((item) => ({
    ...item,
    complete
  }))
  this.setState({
    items: newItems,
    allComplete: complete
  })
}
```
  
## 5. Create a List of Items with a React Native ListView  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/listview  
Compare : https://github.com/browniefed/examples/compare/todo/togglecomplete...todo/listview  
  
row.js  
  * import { View, Text, StyleSheet } from "react-native";  
  * `<View>`  
    * `<Text style={styles.text}>{this.props.text}</Text>`  
  
app.js  
  * `<View>`  
    * `<Header>`  
    * `<View>`  
      * `<ListView>`  
        * enableEmptySections  
        * dataSource={this.state.dataSource}  
        * renderRow={({ key, ...value}) => { return `<Row ... />` }  
        * renderSeparator={(sectionId, rowId) => { ... }  
        *  
        *  onScroll={() => Keyboard.dismiss()}  
    * `<Footer>`  
  
  * Keyboard   
```
import { ..., Keyboard } from "react-native";

<ListView
  ...
  onScroll={() => Keyboard.dismiss()}
  ...
/>
```
  * DataSource  
```
import { ..., ListView, ... } from "react-native";

  constructor(props) {
    ...
    const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
    this.state = {
      ...,
      dataSource: ds.cloneWithRows([])
    }
    ...
  }
  setSource(items, itemsDatasource, otherState = {}) {
    this.setState({
      items,
      dataSource: this.state.dataSource.cloneWithRows(itemsDatasource),
      ...otherState
    })
  }
  handleToggleAllComplete() {
    ...
    this.setSource(newItems, newItems, { allComplete: complete })
  }
  handleAddItem() {
    ...
    this.setSource(newItems, newItems, { value: "" })
  }
  render() {
    return (
      ...
          <ListView
            ...
            dataSource={this.state.dataSource}
            ...
          />
      ...
    );
  }
```
  
## 6. Add a Complete Toggle with React Native Switch  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/rowtoggleswitch  
Compare : https://github.com/browniefed/examples/compare/todo/listview...todo/rowtoggleswitch  
  
row.js  
  * import { ..., Switch } from "react-native";  
  * `<View>`  
    * `<Switch>`  
      * value={this.props.complete}  
      * onValueChange={this.props.onComplete}  
    * `<View>`  
      * `<Text style={[styles.text, complete && styles.complete]}>{this.props.text}</Text>`  
  
app.js  
  * `<View>`  
    * `<Header>`  
    * `<View>`  
      * `<ListView>`  
        * renderRow={({ key, ...value}) => return  
          * `<Row>`  
            * onComplete={(complete) => this.handleToggleComplete(key, complete)}  
        * ...  
  * handleToggleComplete   
```
const newItems = this.state.items.map((item) => {
  if (item.key !== key) return item;
  return {
    ...item,
    complete
  }
})
this.setSource(newItems, newItems);
```
  
## 7. Add a Remove Item Button to Each Row with React Native TouchableOpacity  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/destroybutton  
Compare : https://github.com/browniefed/examples/compare/todo/rowtoggleswitch...todo/destroybutton  
  
row.js  
  * import { ..., TouchableOpacity } from "react-native";  
  * `<View>`  
    * `<Switch>`  
    * `<View>`  
    * `<TouchableOpacity>`  
      * onPress={this.props.onRemove}  
      * `<Text style={styles.destroy}>X</Text>`  
  
app.js  
  * `<View>`  
    * `<Header>`  
    * `<View>`  
      * `<ListView>`  
        * renderRow={({ key, ...value}) => return  
          * `<Row>`  
            * onRemove={() => this.handleRemoveItem(key)}  
        * ...  
  * handleRemoveItem   
```
handleRemoveItem(key) {
  const newItems = this.state.items.filter((item) => {
    return item.key !== key
  })
  this.setSource(newItems, newItems);
}
```

## 8. Filter Items in the React Native List View  

Repo & branch : https://github.com/browniefed/examples/tree/todo/filteritems  
Compare : https://github.com/browniefed/examples/compare/todo/destroybutton...todo/filteritems  
  
footer.js  
  * import { ..., TouchableOpacity } from "react-native";  
  * `<View>`  
    * `<View>`  
      * `<View>`  
      * `<TouchableOpacity>`  
        * onPress={() => this.props.onFilter("ALL")  
      * `<TouchableOpacity>`  
        * onPress={() => this.props.onFilter("ACTIVE")}  
      * `<TouchableOpacity>`  
        * onPress={() => this.props.onFilter("COMPLETED")}  
  
app.js  
  * `<View>`  
    * `<Footer>`  
      * filter={this.state.filter}  
      *  
      * onFilter={this.handleFilter}  
  * filterItems   
```
const filterItems = (filter, items) => {
  return items.filter((item) => {
    if (filter === "ALL") return true;
    if (filter === "COMPLETED") return item.complete;
    if (filter === "ACTIVE") return !item.complete;
  })
}
```
  * Updating the parameter of `setSrouce`  
```
  handleFilter(filter) {
    this.setSource(this.state.items, filterItems(filter, this.state.items), { filter })
  }
  handleRemoveItem(key) {
    ...
    this.setSource(newItems, filterItems(this.state.filter, newItems));
  }
  handleToggleComplete(key, complete) {
    ...
    this.setSource(newItems, filterItems(this.state.filter, newItems));
  }
  handleToggleAllComplete() {
    ...
    this.setSource(newItems, filterItems(this.state.filter, newItems), { allComplete: complete })
  }
  handleAddItem() {
    ...
    this.setSource(newItems, filterItems(this.state.filter, newItems), { value: "" })
  }
  render() {
    return (
      ...
        <Footer 
          onFilter={this.handleFilter}
          filter={this.state.filter}
        />
      ...
    );
  }
```
  * style with {[ , ]}  
```
<TouchableOpacity style={[styles.filter, filter === "ALL" && styles.selected]} ...>
```
  
## 9. Add the Total Remaining Item Count to the Footer with React Native Text  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/activecount  
Compare : https://github.com/browniefed/examples/compare/todo/filteritems...todo/activecount  
  
footer.js  
  * import { ..., TouchableOpacity } from "react-native";  
  * `<View>`  
    * `<Text>{this.props.count} count</Text>`  
    * `<View>`  
  
app.js  
  * `<View>`  
    * `<Footer>`  
      * count={filterItems("ACTIVE", this.state.items).length}  
  
## 10. Add a Clear All Complete Button to the Footer with React Native TouchableOpacity  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/clearcompleted  
Compare : https://github.com/browniefed/examples/compare/todo/activecount...todo/clearcompleted  
  
footer.js  
  * import { ..., TouchableOpacity } from "react-native";  
  * `<View>`  
    * `<Text>{this.props.count} count</Text>`  
    * `<View>`  
    * `<TouchableOpacity >`  
      * onPress={this.props.onClearComplete}  
      * `<Text>Clear Completed</Text>`  
  
app.js  
  * `<View>`  
    * `<Footer>`  
      * onClearComplete={this.handleClearComplete}  
```
handleClearComplete() {
  const newItems = filterItems("ACTIVE", this.state.items);
  this.setSource(newItems, filterItems(this.state.filter, newItems));
}
```
  
## 11. Persist Items with React Native AsyncStorage  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/asyncstorage  
Compare : https://github.com/browniefed/examples/compare/todo/clearcompleted...todo/asyncstorage  
  
app.js  
  * import { ..., AsyncStorage } from "react-native";  
  * componentWillMount(), setSource()  
```
componentWillMount() {
  AsyncStorage.getItem("items").then((json) => {
    try {
      const items = JSON.parse(json);
      this.setSource(items, items);
    } catch(e) {

    }
  })
}
setSource(items, itemsDatasource, otherState = {}) {
  this.setState({
    ...
  })
  AsyncStorage.setItem("items", JSON.stringify(items));
}
```
  
## 12. Add a Loading Indicator While Loading Items with React Native ActivityIndicator  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/activityindicator  
Compare : https://github.com/browniefed/examples/compare/todo/asyncstorage...todo/activityindicator  
  
app.js  
  * import { ..., AsyncStorage } from "react-native";  
  * render()  
```
<ActivityIndicator
  animating
  size="large"
/>
```
  
## 13. Inline Edit Todo Items in a React Native ListView  
  
Repo & branch : https://github.com/browniefed/examples/tree/todo/editing  
Compare : https://github.com/browniefed/examples/compare/todo/activityindicator...todo/editing  
  
row.js  
  * import { ..., TouchableOpacity } from "react-native";  
  * `<View>`  
    * `<Switch>`  
    * ~`<View>`~ {this.props.editing ? editingComponent : textComponent}  
    * ~`<TouchableOpacity>`~ {this.props.editing ? doneButton : removeButton}  
  * editingComponent() , doneButton()  
```
const editingComponent = (
  <View style={styles.textWrap}>
    <TextInput 
      onChangeText={this.props.onUpdate}
      autoFocus
      value={this.props.text}
      style={styles.input}
      multiline
    />
  </View>
)
const doneButton = (
  <TouchableOpacity style={styles.done} onPress={() => this.props.onToggleEdit(false)}>
    <Text style={styles.doneText}>Save</Text>
  </TouchableOpacity>
)
```
  
app.js  
  * `<View>`  
    * `<Header>`  
    * `<View>`  
      * `<ListView>`  
        * renderRow={({ key, ...value}) => return  
          * `<Row>`  
            * onUpdate={(text) => this.handleUpdateText(key, text)}  
            * onToggleEdit={(editing) => this.handleToggleEditing(key, editing)}  
  * handleUpdateText() , handleToggleEditing()  
```
  handleUpdateText(key, text) {
    const newItems = this.state.items.map((item) => {
      if (item.key !== key) return item;
      return {
        ...item,
        text
      }
    })
    this.setSource(newItems, filterItems(this.state.filter, newItems));
  }
  handleToggleEditing(key, editing) {
    const newItems = this.state.items.map((item) => {
      if (item.key !== key) return item;
      return {
        ...item,
        editing
      }
    })
    this.setSource(newItems, filterItems(this.state.filter, newItems));
  }
```
  
## Resources
  
### Code Snippets  
  
https://gist.github.com/browniefed/abc2460df79d9dbae5421cde951e1ed1  
  
