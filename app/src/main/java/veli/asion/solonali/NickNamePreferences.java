package veli.asion.solonali;

import android.content.Context;
import android.content.SharedPreferences;

public class NickNamePreferences {
    private static final String PREF_NAME = "my_preferences2";

    private static final String place1_squirrel = "place1_squirrel";
    private static final String place2_squirrel = "place3_squirrel";
    private static final String place3_squirrel = "place2_squirrel";

    private static final String place1_fawn = "place1_fawn";
    private static final String place2_fawn = "place2_fawn";
    private static final String place3_fawn = "place3_fawn";

    private static final String place1_eagle = "place1_eagle";
    private static final String place2_eagle = "place2_eagle";
    private static final String place3_eagle = "place3_eagle";

    private SharedPreferences sharedPreferences;

    public NickNamePreferences(Context context) {

        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public String[] getPlaces_fawn() {
        return new String[]{sharedPreferences.getString(place1_fawn, "Nickname"),
        sharedPreferences.getString(place2_fawn, "Nickname"),
        sharedPreferences.getString(place3_fawn, "Nickname")};
    }

    public String[] getPlaces_squirrel(){

         return new String[]{sharedPreferences.getString(place1_squirrel, "Nickname"),
        sharedPreferences.getString(place2_squirrel, "Nickname"),
        sharedPreferences.getString(place3_squirrel, "Nickname")};
    }

    public String[] getPlaces_eagle(){

        return new String[]{sharedPreferences.getString(place1_eagle, "Nickname"),
                sharedPreferences.getString(place2_eagle, "Nickname"),
                sharedPreferences.getString(place3_eagle, "Nickname")};
    }
    public void setPlace1_squirrel(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place1_squirrel, nick);
        editor.apply();
    }
    public void setPlace2_squirrel(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place2_squirrel, nick);
        editor.apply();
    }
    public void setPlace3_squirrel(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place3_squirrel, nick);
        editor.apply();
    }

    public void setPlace1_fawn(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place1_fawn, nick);
        editor.apply();
    }
    public void setPlace2_fawn(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place3_fawn, nick);
        editor.apply();
    }
    public void setPlace3_fawn(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place3_fawn, nick);
        editor.apply();
    }

    public void setPlace1_eagle(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place1_eagle, nick);
        editor.apply();
    }
    public void setPlace2_eagle(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place2_eagle, nick);
        editor.apply();
    }
    public void setPlace3_eagle(String nick){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(place3_eagle, nick);
        editor.apply();
    }
}
