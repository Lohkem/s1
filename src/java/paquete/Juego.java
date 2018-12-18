/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.util.Random;

/**
 *
 * @author Lokem
 */
@WebServlet(name = "Juego", urlPatterns = {"/Juego"})
public class Juego extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Juego</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Juego at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CONTENT_TYPE = "text/html";
        response.setContentType(CONTENT_TYPE);
        ServletOutputStream out = response.getOutputStream();
        Random rand = new Random();
        int number;
        int attempts = 0;
        String name = null;
        
        javax.servlet.http.HttpSession session = request.getSession(true);
        if(session.isNew())
        {
            number = rand.nextInt(100)+1;
            name = request.getParameter("nombre");
            session.setAttribute("number", number);
            session.setAttribute("nombre", name);
            session.setAttribute("attempts", attempts);
        }else{
            number = Integer.parseInt(session.getAttribute("number").toString());
            name = session.getAttribute("nombre").toString();
            attempts =  Integer.parseInt(session.getAttribute("attempts").toString());
            attempts = attempts + 1;
        }
        
        String header = "Juego - Adivina el número ";
        String myvar = null;
        
        if(request.getParameter("numberguessed")!= null)
        {
            if(number == Integer.parseInt(request.getParameter("numberguessed")))
            {
                myvar = "<html>"+
                "	<head>"+
                "		<title>"+ header +"</title>"+
                "	</head>"+
                "	<body BGCOLOR=\"#FDF5E6\">"+
                "		<H1 ALIGN=\"CENTER\"> Felicidades "+ name +", has ganado en "+ attempts +" intentos! </H1>"+
                "		<a href=\"inicio.html\">Volver a jugar</a>"+
                "	</body>"+
                "</html>";
                session.invalidate();
                out.println(myvar);
                return;
                
            }else if(Integer.parseInt(request.getParameter("numberguessed")) < number  && Integer.parseInt(request.getParameter("numberguessed")) >= 1){
                header = "El número es mayor que tu número adivinado";
            }else if(Integer.parseInt(request.getParameter("numberguessed")) > number  && Integer.parseInt(request.getParameter("numberguessed")) <= 100){
                header = "El número es menor que tu número adivinado";
            }else{
                myvar = "<html>"+
                "	<head>"+
                "		<title>"+ header +"</title>"+
                "	</head>"+
                "	<body BGCOLOR=\"#FDF5E6\">"+
                "		<H1 ALIGN=\"CENTER\"> Has introducido un valor inválido, GAME OVER! </H1>"+
                "		<a href=\"inicio.html\">Volver a jugar</a>"+
                "	</body>"+
                "</html>";
                session.invalidate();
                out.println(myvar);
                return;
            }
        }
        
        
        myvar = "<html>"+
        "<head>"+
        "      <title>Adivina el número</title>"+
        "</head>"+
        "<body BGCOLOR=\"#FDF5E6\">"+
        "      <H1 ALIGN=\"CENTER\">"+ header +"</H1>"+
        "      <center>"+
        "            Adivina un número entre 1 y 100<br>"+
        "            Inserta tu numero en la casilla vacía<br>"+
        "            Si adivinas ganaste!<br><br>"+
        "      </ul>"+
        "      <form id=\"form2\" name=\"form2\" method=\"post\" action=\"Juego\">"+
        "            <select name=\"numberguessed\">"+
        "                  <option value=\"1\">1</option>"+
        "                  <option value=\"2\">2</option>"+
        "                  <option value=\"3\">3</option>"+
        "                  <option value=\"4\">4</option>"+
        "                  <option value=\"5\">5</option>"+
        "                  <option value=\"6\">6</option>"+
        "                  <option value=\"7\">7</option>"+
        "                  <option value=\"8\">8</option>"+
        "                  <option value=\"9\">9</option>"+
        "                  <option value=\"10\">10</option>"+
        "                  <option value=\"11\">11</option>"+
        "                  <option value=\"12\">12</option>"+
        "                  <option value=\"13\">13</option>"+
        "                  <option value=\"14\">14</option>"+
        "                  <option value=\"15\">15</option>"+
        "                  <option value=\"16\">16</option>"+
        "                  <option value=\"17\">17</option>"+
        "                  <option value=\"18\">18</option>"+
        "                  <option value=\"19\">19</option>"+
        "                  <option value=\"20\">20</option>"+
        "                  <option value=\"21\">21</option>"+
        "                  <option value=\"22\">22</option>"+
        "                  <option value=\"23\">23</option>"+
        "                  <option value=\"24\">24</option>"+
        "                  <option value=\"25\">25</option>"+
        "                  <option value=\"26\">26</option>"+
        "                  <option value=\"27\">27</option>"+
        "                  <option value=\"28\">28</option>"+
        "                  <option value=\"29\">29</option>"+
        "                  <option value=\"30\">30</option>"+
        "                  <option value=\"31\">31</option>"+
        "                  <option value=\"32\">32</option>"+
        "                  <option value=\"33\">33</option>"+
        "                  <option value=\"34\">34</option>"+
        "                  <option value=\"35\">35</option>"+
        "                  <option value=\"36\">36</option>"+
        "                  <option value=\"37\">37</option>"+
        "                  <option value=\"38\">38</option>"+
        "                  <option value=\"39\">39</option>"+
        "                  <option value=\"40\">40</option>"+
        "                  <option value=\"41\">41</option>"+
        "                  <option value=\"42\">42</option>"+
        "                  <option value=\"43\">43</option>"+
        "                  <option value=\"44\">44</option>"+
        "                  <option value=\"45\">45</option>"+
        "                  <option value=\"46\">46</option>"+
        "                  <option value=\"47\">47</option>"+
        "                  <option value=\"48\">48</option>"+
        "                  <option value=\"49\">49</option>"+
        "                  <option value=\"50\">50</option>"+
        "                  <option value=\"51\">51</option>"+
        "                  <option value=\"52\">52</option>"+
        "                  <option value=\"53\">53</option>"+
        "                  <option value=\"54\">54</option>"+
        "                  <option value=\"55\">55</option>"+
        "                  <option value=\"56\">56</option>"+
        "                  <option value=\"57\">57</option>"+
        "                  <option value=\"58\">58</option>"+
        "                  <option value=\"59\">59</option>"+
        "                  <option value=\"60\">60</option>"+
        "                  <option value=\"61\">61</option>"+
        "                  <option value=\"62\">62</option>"+
        "                  <option value=\"63\">63</option>"+
        "                  <option value=\"64\">64</option>"+
        "                  <option value=\"65\">65</option>"+
        "                  <option value=\"66\">66</option>"+
        "                  <option value=\"67\">67</option>"+
        "                  <option value=\"68\">68</option>"+
        "                  <option value=\"69\">69</option>"+
        "                  <option value=\"70\">70</option>"+
        "                  <option value=\"71\">71</option>"+
        "                  <option value=\"72\">72</option>"+
        "                  <option value=\"73\">73</option>"+
        "                  <option value=\"74\">74</option>"+
        "                  <option value=\"75\">75</option>"+
        "                  <option value=\"76\">76</option>"+
        "                  <option value=\"77\">77</option>"+
        "                  <option value=\"78\">78</option>"+
        "                  <option value=\"79\">79</option>"+
        "                  <option value=\"80\">80</option>"+
        "                  <option value=\"81\">81</option>"+
        "                  <option value=\"82\">82</option>"+
        "                  <option value=\"83\">83</option>"+
        "                  <option value=\"84\">84</option>"+
        "                  <option value=\"85\">85</option>"+
        "                  <option value=\"86\">86</option>"+
        "                  <option value=\"87\">87</option>"+
        "                  <option value=\"88\">88</option>"+
        "                  <option value=\"89\">89</option>"+
        "                  <option value=\"90\">90</option>"+
        "                  <option value=\"91\">91</option>"+
        "                  <option value=\"92\">92</option>"+
        "                  <option value=\"93\">93</option>"+
        "                  <option value=\"94\">94</option>"+
        "                  <option value=\"95\">95</option>"+
        "                  <option value=\"96\">96</option>"+
        "                  <option value=\"97\">97</option>"+
        "                  <option value=\"98\">98</option>"+
        "                  <option value=\"99\">99</option>"+
        "                  <option value=\"100\">100</option>"+
        "            </select><br><br>"+
        "            <input type=\"submit\" name=\"Submit\" value=\"Juega\"/></center>"+
        "      </form>"+
        "</body>"+
        "</html>";
        session.setAttribute("attempts", attempts);
        out.println(myvar);
    }
       
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
