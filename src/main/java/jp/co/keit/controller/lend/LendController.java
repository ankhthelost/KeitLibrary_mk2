package jp.co.keit.controller.lend;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.keit.bean.LendBean;
import jp.co.keit.entity.Book;
import jp.co.keit.entity.Order;
import jp.co.keit.entity.Status;
import jp.co.keit.entity.User;
import jp.co.keit.form.LendForm;
import jp.co.keit.repository.BookRepository;
import jp.co.keit.repository.OrderRepository;
import jp.co.keit.repository.StatusRepository;
import jp.co.keit.repository.UserRepository;

@Controller
public class LendController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(path = "/lend/input", method = RequestMethod.GET)
	public String showLendInput(@ModelAttribute LendForm lendForm, Integer bookId, Model model) {
		model.addAttribute("bookId", bookId);
		return "lend/lend_input";
	}
	
	@RequestMapping(path = "/lend/check", method = RequestMethod.POST)
	public String moveToLendCheck(@Valid @ModelAttribute LendForm lendForm, BindingResult result,
			Model model) {
		// 入力値チェック(エラーがある場合、入力画面へ。) 
		if(result.hasErrors()) {
			return "lend/lend_input";
		}else {
			// lendBeanを生成
			LendBean lendBean = new LendBean();
			
			// 値をセット
			lendBean.setUserName(lendForm.getUserName());
			lendBean.setMailAddress(lendForm.getMailAddress());
			lendBean.setPhoneNumber(lendForm.getPhoneNumber());
			lendBean.setAddress(lendForm.getAddress());
			
			Book book = bookRepository.findById(lendForm.getBookId()).orElse(null);
			
			lendBean.setBook(book);
			
			model.addAttribute("lendBean", lendBean);
			
			return "lend/lend_check";
		}
	}
	
	@RequestMapping(path = "/lend/complete", method = RequestMethod.POST)
	public String lendComplete(LendBean lendBean, Integer bookId) {
		// 注文エンティティを生成
		Order order = new Order();
		
		// Orderに格納する書籍データを取得
		Book book = bookRepository.findById(bookId).orElse(null);
		
		// ここに判定式をぶち込む(Statusのステidが1の場合)。
	    // それ以外の場合、エラー画面に飛んでもらう。
	
			// ステータス情報を取得
			Status status = statusRepository.findById(2).orElse(null);
			
			// 書籍のステを更新
			book.setStatus(status);
			
			// ステ更新したbookを保存
			bookRepository.save(book);
			
			// Orderに格納するユーザデータをセッションより取得
			User user = (User)session.getAttribute("user");
			
			// Orderの各カラムに値をセット
			order.setBook(book);
			order.setUser(user);
			order.setSendName(lendBean.getUserName());
			order.setSendAddress(lendBean.getAddress());
			order.setSendMailAddress(lendBean.getMailAddress());
			order.setSendPhoneNum(lendBean.getPhoneNumber());
			order.setDeleteFlg((short)0);
			
			// Ordersテーブルに登録
			order = orderRepository.save(order);
			
			// 完了画面へ遷移
			return "lend/lend_complete";
		
	}	
}
