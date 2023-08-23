package veli.asion.solonali;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;

public class AppPreferences {
    private static final String PREF_NAME = "my_preferences";

    private static final String KEY_Squirrel1 = "Squirrel1";
    private static final String KEY_Squirrel2 = "Squirrel2";
    private static final String KEY_Squirrel3 = "Squirrel3";
    private static final String KEY_Squirrel4 = "Squirrel4";
    private static final String KEY_Squirrel5 = "Squirrel5";
    private static final String KEY_Squirrel6 = "Squirrel6";
    private static final String KEY_Squirrel7 = "Squirrel7";
    private static final String KEY_Squirrel8 = "Squirrel8";
    private static final String KEY_Squirrel9 = "Squirrel9";
    private static final String KEY_Squirrel10 = "Squirrel10";
    private static final String[] KEYS_Squirrels = new String[]{KEY_Squirrel1,
                                                                KEY_Squirrel2,
                                                                KEY_Squirrel3,
                                                                KEY_Squirrel4,
                                                                KEY_Squirrel5,
                                                                KEY_Squirrel6,
                                                                KEY_Squirrel7,
                                                                KEY_Squirrel8,
                                                                KEY_Squirrel9,
                                                                KEY_Squirrel10};


    private static final String KEY_Fawn1 = "Fawn1";
    private static final String KEY_Fawn2 = "Fawn2";
    private static final String KEY_Fawn3 = "Fawn3";
    private static final String KEY_Fawn4 = "Fawn4";
    private static final String KEY_Fawn5 = "Fawn5";
    private static final String KEY_Fawn6 = "Fawn6";
    private static final String KEY_Fawn7 = "Fawn7";
    private static final String KEY_Fawn8 = "Fawn8";
    private static final String KEY_Fawn9 = "Fawn9";
    private static final String KEY_Fawn10 = "Fawn10";
    private static final String[] KEYS_Fawns = new String[]{KEY_Fawn1 ,
                                                            KEY_Fawn2 ,
                                                            KEY_Fawn3 ,
                                                            KEY_Fawn4 ,
                                                            KEY_Fawn5 ,
                                                            KEY_Fawn6 ,
                                                            KEY_Fawn7 ,
                                                            KEY_Fawn8 ,
                                                            KEY_Fawn9 ,
                                                            KEY_Fawn10};

    private static final String KEY_Eagle1 = "Eagle1";
    private static final String KEY_Eagle2 = "Eagle2";
    private static final String KEY_Eagle3 = "Eagle3";
    private static final String KEY_Eagle4 = "Eagle4";
    private static final String KEY_Eagle5 = "Eagle5";
    private static final String KEY_Eagle6 = "Eagle6";
    private static final String KEY_Eagle7 = "Eagle7";
    private static final String KEY_Eagle8 = "Eagle8";
    private static final String KEY_Eagle9 = "Eagle9";
    private static final String KEY_Eagle10 = "Eagle10";

    private static final String[] KEYS_Eagles = new String[]{   KEY_Eagle1 ,
                                                                KEY_Eagle2 ,
                                                                KEY_Eagle3 ,
                                                                KEY_Eagle4 ,
                                                                KEY_Eagle5 ,
                                                                KEY_Eagle6 ,
                                                                KEY_Eagle7 ,
                                                                KEY_Eagle8 ,
                                                                KEY_Eagle9 ,
                                                                KEY_Eagle10};
    private SharedPreferences sharedPreferences;

    public AppPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }


    public int getMaxSquirrel(){
        int [] nums= getAllSquirrels();
        return nums[nums.length-1];
    }
    public int[] getAllSquirrels() {
        int [] numbers = new int[]{
                sharedPreferences.getInt(KEY_Squirrel1, 0),
                sharedPreferences.getInt(KEY_Squirrel2, 0),
                sharedPreferences.getInt(KEY_Squirrel3, 0),
                sharedPreferences.getInt(KEY_Squirrel4, 0),
                sharedPreferences.getInt(KEY_Squirrel5, 0),
                sharedPreferences.getInt(KEY_Squirrel6, 0),
                sharedPreferences.getInt(KEY_Squirrel7, 0),
                sharedPreferences.getInt(KEY_Squirrel8, 0),
                sharedPreferences.getInt(KEY_Squirrel9, 0),
                sharedPreferences.getInt(KEY_Squirrel10, 0)};
        Arrays.sort(numbers);

        return numbers;
    }
    public void addSquirrel(int newNum) {
        int [] nums = getAllSquirrels();
        nums = replaceFirstGreaterOrEqual(nums, newNum);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < nums.length; i++) {
            editor.putInt(KEYS_Squirrels[i],nums[(nums.length-1)-i]);
        }
        editor.apply();
    }

    public static int[] replaceFirstGreaterOrEqual(int[] numbers, int newNumber) {
        int[] onepart;
        int[] secpart;
        int[] result = new int[]{};

        for (int i = numbers.length-1; i >= 0; i--) {

            if (numbers[i]<=newNumber && numbers[0]<numbers[i] || numbers[i]==0){
                onepart = Arrays.copyOfRange(numbers, 0, i+1);
                numbers[i] = newNumber;
                secpart = Arrays.copyOfRange(numbers, i, numbers.length);
                result = new int[onepart.length - 1];
                System.arraycopy(onepart, 1, result, 0, result.length);
                numbers = Arrays.copyOf(result, result.length + secpart.length);
                System.arraycopy(secpart, 0, numbers, result.length, secpart.length);

                break;
            }

        }
        return numbers;
    }

    public int getMaxFawn(){
        int [] nums= getAllFawns();
        return nums[nums.length-1];
    }
    public int[] getAllFawns() {
        int [] numbers = new int[]{
                sharedPreferences.getInt(KEY_Fawn1 ,0),
                sharedPreferences.getInt(KEY_Fawn2 ,0),
                sharedPreferences.getInt(KEY_Fawn3 ,0),
                sharedPreferences.getInt(KEY_Fawn4 ,0),
                sharedPreferences.getInt(KEY_Fawn5 ,0),
                sharedPreferences.getInt(KEY_Fawn6 ,0),
                sharedPreferences.getInt(KEY_Fawn7 ,0),
                sharedPreferences.getInt(KEY_Fawn8 ,0),
                sharedPreferences.getInt(KEY_Fawn9 ,0),
                sharedPreferences.getInt(KEY_Fawn10, 0)};
        Arrays.sort(numbers);
        return numbers;
    }
    public void addFawn(int newNum) {
        int [] nums = getAllFawns();
        nums = replaceFirstGreaterOrEqual(nums, newNum);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < nums.length; i++) {
            editor.putInt(KEYS_Fawns[i],nums[(nums.length-1)-i]);
        }
        editor.apply();
    }
    public int getMaxEagles(){
        int [] nums= getAllEagles();
        return nums[nums.length-1];
    }
    public int[] getAllEagles() {
        int [] numbers = new int[]{
                sharedPreferences.getInt(KEY_Eagle1 , 0),
                sharedPreferences.getInt(KEY_Eagle2 , 0),
                sharedPreferences.getInt(KEY_Eagle3 , 0),
                sharedPreferences.getInt(KEY_Eagle4 , 0),
                sharedPreferences.getInt(KEY_Eagle5 , 0),
                sharedPreferences.getInt(KEY_Eagle6 , 0),
                sharedPreferences.getInt(KEY_Eagle7 , 0),
                sharedPreferences.getInt(KEY_Eagle8 , 0),
                sharedPreferences.getInt(KEY_Eagle9 , 0),
                sharedPreferences.getInt(KEY_Eagle10, 0)};
        Arrays.sort(numbers);
        return numbers;
    }
    public void addEagle(int newNum) {
        int [] nums = getAllEagles();
        nums = replaceFirstGreaterOrEqual(nums, newNum);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < nums.length; i++) {
            editor.putInt(KEYS_Eagles[i],nums[(nums.length-1)-i]);
        }
        editor.apply();
    }

}
