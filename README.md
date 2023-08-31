# UC_10
## Application description
This application was created as part of "Generative AI" research. 
Normal android components like activities, fragment were intentionally skipped. 
There are only one class (extension function to check if sentence is valid) and unit test.


## Regex implementation description
During implementation _kotlin.text.Regex_ was used. Entry point is _isValid_ extension for String class
```
```
isValid(maxLength:Int)
```
````
Use this method to check if sentence meets the following requirements:
* at least one uppercase letter is present
* at least one lowercase letter is present 
* at least one digit is present
* at least one special character from a predefined list: !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~.
* no whitespaces
* sentence is not bigger then proved max length.

Unfortunately implementation took more time then I expected. I would be faster with GPT.

## how open and run the project tests locally?
First of all, you need download android studio and all related stuff. 
Then open this project using New -> Project From Version Control.
Please paste gitHub link and follow instruction.
Find RegexTest and run it.

