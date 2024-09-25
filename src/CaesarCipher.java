public class CaesarCipher
{
    private int shift;
    private Locale locale;

    CaesarCipher()
    {
        this.shift = 3;
        this.locale = Locale.en;
    }

    CaesarCipher(int shift)
    {
        this.shift = shift;
        this.locale = Locale.en;
    }

    CaesarCipher(int shift, Locale locale)
    {
        this.shift = shift;
        this.locale = locale;
    }


    private char performChar(char ch, int min, int max, boolean encrypt)
    {
        int temp;

        if(encrypt)
        {
            temp = (int)ch + this.shift;
        }
        else
        {
            temp = (int)ch + -1 * this.shift;
        }

        if (temp > max)
        {
            return (char) (min - 1 + (temp - max));
        }
        else if (temp < min)
        {
            return (char) (max + 1 - (min - temp));
        }
        else
        {
            return (char) temp;
        }
    }

    public String encrypt(String str)
    {
        String newStr = "";
        str = str.replaceAll("\\p{Punct}", "");

        if (locale == Locale.en)
        {
            for (int i = 0; i < str.length(); i++)
            {
                if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90)
                {
                    newStr += performChar(str.charAt(i), 65, 90, true);
                }
                else if ((int) str.charAt(i) >= 97 && (int) str.charAt(i) <= 122)
                {
                    newStr += performChar(str.charAt(i), 97, 122, true);
                }
                else if(str.charAt(i) == ' ')
                {
                    newStr += str.charAt(i);
                }
            }
        }
        else if (locale == Locale.ru)
        {
            for (int i = 0; i < str.length(); i++)
            {
                if ((int) str.charAt(i) >= 1040 && (int) str.charAt(i) <= 1071)
                {
                    newStr += performChar(str.charAt(i), 1040, 1071, true);
                }
                else if ((int) str.charAt(i) >= 1072 && (int) str.charAt(i) <= 1103)
                {
                    newStr += performChar(str.charAt(i), 1072, 1103, true);
                }
                else if(str.charAt(i) == ' ')
                {
                    newStr += str.charAt(i);
                }
            }
        }
        return newStr;
    }

    public String decrypt(String str)
    {
        String newStr = "";
        str = str.replaceAll("\\p{Punct}", "");

        if (locale == Locale.en)
        {
            for (int i = 0; i < str.length(); i++)
            {
                if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90)
                {
                    newStr += performChar(str.charAt(i), 65, 90, false);
                }
                else if ((int) str.charAt(i) >= 97 && (int) str.charAt(i) <= 122)
                {
                    newStr += performChar(str.charAt(i), 97, 122, false);
                }
                else if(str.charAt(i) == ' ')
                {
                    newStr += str.charAt(i);
                }
            }
        }
        else if (locale == Locale.ru)
        {
            for (int i = 0; i < str.length(); i++)
            {
                if ((int) str.charAt(i) >= 1040 && (int) str.charAt(i) <= 1071)
                {
                    newStr += performChar(str.charAt(i), 1040, 1071, false);
                }
                else if ((int) str.charAt(i) >= 1072 && (int) str.charAt(i) <= 1103)
                {
                    newStr += performChar(str.charAt(i), 1072, 1103, false);
                }
                else if(str.charAt(i) == ' ')
                {
                    newStr += str.charAt(i);
                }
            }
        }

        return newStr;
    }


}
