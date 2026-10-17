import java.awt.Desktop;
import java.net.URI;

public class BrowserOpener {
    public void openArticle(int pageId) {
        String url = "https://ru.wikipedia.org/w/index.php?curid=" + pageId;
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
                System.out.println("Статья успешно открыта в браузере!");
            } else {
                System.out.println("Автоматическое открытие не поддерживается. Ссылка на статью: " + url);
            }
        } catch (Exception e) {
            System.out.println("Не удалось открыть браузер. Вы можете перейти по ссылке вручную: " + url);
        }
    }
}