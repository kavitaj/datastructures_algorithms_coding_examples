package com.string.examples;

public class PalindromePermutation {

    //Time complexity: O(n), where n is the length of the string
    boolean isPermutationOfPalindrome(String phrase){
        int[] table=buildCharFrquencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    int[] buildCharFrquencyTable(String phrase){
        int[] table=new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for (char c: phrase.toCharArray()){
            int x=getCharNumber(c);
            if(x!=-1){
                table[x]++;
            }
        }
        return table;
    }

    int getCharNumber(Character c){
        int a=Character.getNumericValue('a');
        int z=Character.getNumericValue('z');
        int val=Character.getNumericValue('c');
        if(a<=val && val<=z){
            return val-a;
        }
        return -1;

    }


    boolean checkMaxOneOdd(int[] table){
        boolean foundOdd=false;
        for(int count: table){
            if(count%2==1){
                if(foundOdd) return false;
                return true;
            }
        }
        return true;
    }




}
