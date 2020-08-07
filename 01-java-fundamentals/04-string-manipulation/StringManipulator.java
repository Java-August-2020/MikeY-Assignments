public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        return str1.trim().concat(str2.trim());
    }

    public Integer getIndexOrNull(String str1, char c) {
        if (str1.indexOf(c) == -1) {
            return null;
        } else {
        return str1.indexOf(c);
        }
    }

    public Integer getIndexOrNull2(String str1, String str2) {
        if (str1.indexOf(str2) != -1) {
            return str1.indexOf(str2);
        } else {
            return null;
        }
    }

    public String concatSubstring(String string3, int int1, int int2, String string4) {
        string3 = string3.substring(int1, int2);
        return string3.concat(string4);
    }
}