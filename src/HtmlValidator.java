import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack  openTags = new Stack<HtmlTag>();
		/* IMPLEMENT THIS METHOD! */


		for (HtmlTag tag : tags) {
			if (!tag.isSelfClosing()) {
				if (tag.isOpenTag()) {

					//System.out.println(tag);
					openTags.push(tag);


				}

		else if(!openTags.empty())  {
				//	if(openTags.peek().equals(tag.getElement())){
				if(tag.matches((HtmlTag) openTags.peek())){
					openTags.pop();
					//System.out.println("borro"+tag.getElement());
				}else{
					//System.out.println("NOborro"+tag.getElement());
					openTags.push(tag);
				}

				}else {
					openTags.push(tag);

				}
			}
		}

	//	System.out.println(tags);
	//System.out.println(openTags);

if(openTags.empty()){
	System.out.println("tags de los archivos validos"+tags);
	return null; // this line is here only so this code will compile if you don't modify it

}else{
	System.out.println("tags de los archivos NO validos"+tags);
	return openTags;
}

	}




}

