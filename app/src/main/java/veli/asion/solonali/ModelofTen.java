package veli.asion.solonali;

public class ModelofTen {
    int number;
    String nickname;
    int points;
    public ModelofTen(int number, String nickname, int points) {
        this.number = number;
        this.nickname = nickname;
        this.points = points;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
