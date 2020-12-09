//package jp.co.keit.Filter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//
//import jp.co.keit.bean.GenreBean;
//import jp.co.keit.entity.Genre;
//import jp.co.keit.repository.GenreRepository;
//
//public class SidebarFilter implements Filter {
//	
//	// ジャンルリポジトリを呼び出し
//	@Autowired
//	GenreRepository genreRepository;
//	
//	@Autowired
//	Model model;
//	
//	/**
//	 *  書籍系画面にフィルタ設置
//	 * 	
//	 */
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response,
//			FilterChain chain) throws IOException, ServletException {
//		
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		
//		String requestURL = httpRequest.getRequestURI();
//		
//		// 特定URLパターンでのみ、処理を実行する。
//		if (requestURL.contains("/book")) {
//			// ジャンル情報を全件取得
//			List<Genre> genres = genreRepository.findAll();
//			
//			List<GenreBean> genreBeans = new ArrayList<>();
//			
//			for(Genre genre : genres) {
//				GenreBean genreBean = new GenreBean();
//				genreBean.setGenreName(genre.getGenreName());
//				genreBean.setBookListSize(genre.getGenresbooksList().size());
//				genreBeans.add(genreBean);
//			}
//			
//			model.addAttribute("genreBeans", genreBeans);
//			
//			chain.doFilter(request, response);
//		} else {
//			chain.doFilter(request, response);
//		}	
//	}	
//}
