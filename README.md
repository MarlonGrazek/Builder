# Usage
## ItemStackBuilder
### As Dependency
#### Repository
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

#### Dependency
```xml
<dependency>
    <groupId>com.github.MarlonGrazek</groupId>
    <artifactId>Builder</artifactId>
    <version>9f9d6930fa</version>
</dependency>
```
        
### In the Plugin
#### `addEnchantment(Enchantment, Integer)`
Adds an Enchantment to the item.
```java
builder.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
```

#### `addGlow()`
Adds the enchantment-glowing to the item. It adds the Enchantment `ARROW_DAMAGE` to the item and hides the Enchantment.
```java
builder.addGlow();
```

#### `addItemFlag(ItemFlag)`
Adds an ItemFlag to the item. ItemFlags are used to hide the attributes of the item.
```java
builder.addItemFlag(ItemFlag.HIDE_ATTRIBUTES);
```

#### `addLoreLine(String)`
Adds a String to the lore list.
```java
builder.addLoreLine("Lore Line");
```

#### `getAmount()`
Returns the amount of the item.
```java
builder.getAmount();
```

#### `getEnchantments()`
Returns a list of all Enchantments of the item.
```java
builder.getEnchantments();
```

#### `getItemFlags()`
Returns an ArrayList with the ItemFlags of the item.
```java
builder.getItemFlags();
```

#### `getItemMeta()`
Returns the ItemMeta of the item. This method will return null if you haven't set an ItemMeta before.
```java
builder.getItemMeta();
```

#### `getLore()`
Returns an ArrayList with the lore of the item.
```java
builder.getLore();
```

#### `getMaterial()`
Returns the Material of the item.
```java
builder.getMaterial();
```

#### `getName()`
Returns the name of the item.
```java
builder.getName();
```

#### `setAmount(Integer)`
Sets the amount of the item.
```java
builder.setAmount(2);
```

#### `setEnchantments(ArrayList<Enchantment>)`
Sets the Enchantments to an ArrayList of Enchantments.
```java
builder.setEnchantments(enchantments);
```

#### `setItemFlags(ArrayList<ItemFlag>)`
Sets the ItemFlags to an ArrayList of ItemFlags.
```java
builder.setItemFlags(itemFlags);
```

#### `setItemFlags(ItemFlag[]`
Sets the ItemFlags to an Array of ItemFlags.
```java
builder.setItemFlags(itemFlags);
```

#### `setItemMeta(ItemMeta)`
Sets the ItemMeta of the item.
```java
builder.setItemMeta(itemMeta);
```

#### `setLore(ArrayList<String>)`
Sets the lore to an ArrayList.
```java
builder.setLore(lore);
```
#### All Methods in one Code
```java
ItemStackBuilder builder = new ItemStackBuilder();

builder.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
builder.addGlow();
builder.addItemFlag(ItemFlag.HIDE_ATTRIBUTES);
builder.addLoreLine("Lore Line");
builder.getAmount();
builder.getEnchantments();
builder.getItemFlags();
builder.getItemMeta();
builder.getLore();
builder.getMaterial();
builder.getName();
builder.setAmount(2);
builder.setEnchantments(enchantments);
builder.setItemFlags(itemFlags);
builder.setItemMeta(itemMeta);
builder.setLore(lore);
builder.setLoreLine("Lore Line 2", 1);
builder.setMaterial(Material.STONE);
builder.setName("Test");

builder.toItemStack();
```
