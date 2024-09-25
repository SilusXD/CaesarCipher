import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите язык 'en' или 'ru': "); String localeStr = in.nextLine();
        System.out.print("Введите размер сдвига: "); int shift = in.nextInt(); in.nextLine();
        System.out.print("Введите текст: "); String str = in.nextLine();

        Locale locale;
        if(localeStr.equals("ru"))
        {
            locale = Locale.ru;
        }
        else
        {
            locale = Locale.en;
        }

        CaesarCipher caesarCipher = new CaesarCipher(shift, locale);

        String encStr = caesarCipher.encrypt(str);
        String decStr = caesarCipher.decrypt(encStr);

        System.out.printf("Зашифрованная строка: %s\n", encStr);
        System.out.printf("Расшифрованная строка: %s\n", decStr);
    }
}