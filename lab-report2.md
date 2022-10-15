# Part 1
Simplest Search Engine
```
#code block
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new QueryHandler());
    }
}

class QueryHandler implements URLHandler {

    List<String> s = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Number: %d", s.size());
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if ("s".equals(parameters[0])) {
                    s.add(parameters[1]);
                    return String.format("List add %s!", parameters[1]);
                }
            }else if (url.getPath().contains("/search")){
                String[] parameters = url.getQuery().split("=");
                String returnS = "";
                if ("s".equals(parameters[0])){
                    for (String s1 : s) {
                        if(s1.contains(parameters[1])){
                            returnS += (" AND "+s1);
                        }
                    }
                }
                if (returnS.startsWith(" AND ")){
                    returnS = returnS.substring(5);
                }
                return String.format("List is %s!", returnS);
            }
            return "404 Not Found!";
        }
    }
}
```


![Image](3-7.png)
This use handleRequest method. The argument is "/add", and the value is "?s=apple". If the value changes, another string will add to the arraylist. If the argument change or "?s=" does not exist, it will return "404 not found!".
![Image](3-8.png)
This use handleRequest method. The argument is "/add", and the value is "?s=pineapple". The argument is "/add", and the value is "?s=apple". If the value changes, another string will add to the arraylist. If the argument change or "?s=" does not exist, it will return "404 not found!".
![Image](3-9.png)
This use handleRequest method. The argument is "/search", and the value is "?s=app". The argument is "/add", and the value is "?s=apple". If the value changes, it will search the given string in the arraylist. If the argument change or "?s=" does not exist, it will return "404 not found!".


# Part 2

In the ArrayExamples.java, there is a bug in the reversed method. 
![Image](3-1.png)
This image is the failure-inducing input. 
![Image](3-2.png)
After running the test, the output shows that it failed. To be specific, the symptom is the new array does not include the reversed elements of the input. However, it only contains 0. So, I need to debug.
![Image](3-3.png)
This image is the fixed code. I exchange the place of arr and newArray in line 19 and leave the others in this line unchanged. So, the last element of arr is the first item of newArray, and so on. Besides, I also change the return array into newArray.

In the given test example, because the input is empty, so the problem is not obvious. After adding elements to the input, we can find where the bug is. Before the modification, newArray is empty, so it cannot give values to arr. So, the order of elements in arr is not changed, but all elements become 0.


In the ListExamples.java, there is a bug in the filter method.
![Image](3-6.png)
This image is the failure-inducing input. 
![Image](3-4.png)
The output failed because the true result is not the same as the expected result. This is because every time a new string is added into the array, the string will add at index 0. So, the order of the elements will be reversed. Therefore, the output is ("Array", "Linked") but not ("Linked", "Array").
![Image](3-5.png)
After revising the code, the string will add to the array in the normal order. 
