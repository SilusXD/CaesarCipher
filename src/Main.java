import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        while (true)
        {
            System.out.print("1. Ручной ввод\n2. Работа с файл ами\n3. Выход\nВведите номер пункта: ");
            char punkt = in.next().charAt(0);
            in.nextLine();

            switch (punkt)
            {
                case '1':
                {
                    CaesarCipher caesarCipher = initCaesarCipher();

                    System.out.print("Зашифровать(1) или Расшифровать(2)?: ");
                    char enOrDec = in.next().charAt(0);
                    in.nextLine();

                    switch (enOrDec)
                    {
                        case '1':
                        {
                            System.out.print("Введите текст: "); String str = in.nextLine();
                            String encStr = caesarCipher.encrypt(str);

                            System.out.printf("Зашифрованная строка: %s\n", encStr);
                            break;
                        }
                        case '2':
                        {
                            System.out.print("Введите текст: "); String str = in.nextLine();
                            String decStr = caesarCipher.decrypt(str);

                            System.out.printf("Расшифрованная строка: %s\n", decStr);
                            break;
                        }
                        default:
                        {
                            System.out.println("Неверный номер!");
                            break;
                        }
                    }
                    break;
                }
                case '2':
                {
                    CaesarCipher caesarCipher = initCaesarCipher();

                    System.out.print("Зашифровать(1) или Расшифровать(2)?: ");
                    char enOrDec = in.next().charAt(0);
                    in.nextLine();
                    switch (enOrDec)
                    {
                        case '1':
                        {
                            System.out.print("Введите путь к файлу: "); String path = in.nextLine();
                            caesarCipher.encryptFile(path); //src/inputEn.txt
                            break;
                        }
                        case '2':
                        {
                            System.out.print("Введите путь к файлу: "); String path = in.nextLine();
                            caesarCipher.decryptFile(path); //src/inputDe.txt
                            break;
                        }
                        default:
                        {
                            System.out.println("Неверный номер!");
                            break;
                        }
                    }
                    break;
                }
                case '3':
                {
                    return;
                }
                default:
                {
                    System.out.println("Неизвестный номер пункта!");
                }
            }
        }
    }

    public static CaesarCipher initCaesarCipher()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите язык 'en' или 'ru': "); String localeStr = in.nextLine();
        System.out.print("Введите размер сдвига: "); int shift = in.nextInt();
        in.nextLine();

        Locale locale;
        if(localeStr.equals("ru"))
        {
            locale = Locale.ru;
        }
        else
        {
            locale = Locale.en;
        }

        return new CaesarCipher(shift, locale);
    }
}