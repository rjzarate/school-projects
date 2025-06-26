For large projects
Contains multiple [[Modules]]
Name of the package is derived from the name of the main package
## `__init__.py` Files
Is **REQUIRED** in **each folder/subfolder** for Python to recognize the package folder and each subfolder

Is **ran** when package/subpackage is **loaded**
- Is usually empty, but **import submodules**
## Loading Submodules/Packages
Have to `import` the subpackage/module, not just the parent folder
## `from` 
Used to load subpackages and packages
### Syntax
`from folderName import x`
- `x` is an **object** from `folderName`
## `__all__` Attribute
Will import **ALL** (variables, functions, and classes) from the
- `from folderName import *`

To grab the certain data:
`__all__ = ["attribute0", "attribute1", ...]`