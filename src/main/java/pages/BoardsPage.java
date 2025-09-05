package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BoardsPage extends BasePage {
    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnCreateNewBoardSubmit;
    @FindBy(xpath = "//*[@class='VmbXKMJLSqfD0U']")
    WebElement popUpMessageBoardDelete;
    @FindBy(xpath = "//button[@data-testid='header-member-menu-button']")
    WebElement btnAccount;
    @FindBy(xpath = "//a[@data-testid='manage-account-link']")
    WebElement btnManageAccount;

    public void createNewBoard(Board board) {
        btnCreateNewBoard.click();
        inputBoardTitle.sendKeys(board.getBoardTitle());
        pause(5);
        btnCreateNewBoardSubmit.click();
    }

//    public void clickBtnCreateNewBoardSubmit(){
//        clickWait(btnCreateNewBoardSubmit,3);
//    }

}
