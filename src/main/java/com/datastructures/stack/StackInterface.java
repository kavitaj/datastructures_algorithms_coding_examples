package com.datastructures.stack;

/**              StackInterface           **/

interface StackInterface<AnyType>
{
/**
* Tests if the stack is empty.
*/
public boolean isEmpty();

/**
*  Removes and returns the item at the top of this stack.
*/
public AnyType pop() throws StackException;

/**
*  Returns the top item without its removal
*/
public AnyType peek() throws StackException;

/**
* Inserts an item onto the top of the stack.
*/
public void push(AnyType e) throws StackException;

/**
* Removes all items from the stack.
*/
public void clear();
}
