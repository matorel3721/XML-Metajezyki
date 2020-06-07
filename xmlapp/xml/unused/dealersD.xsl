<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
    <xsl:template match="/">
        <html>
            <head>
                <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
                      rel="stylesheet"
                      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
                      crossorigin="anonymous"/>
            </head>
            <body>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="dealers.xml">Komisy</a>
      </li>
     <li class="nav-item active">
        <a class="nav-link" href="cars.xml">Samochody</a>
      </li>
    </ul>
  </div>
</nav>
<div class="jumbotron">

                
                    
                        <h1 style="text-align: center;">Komisy</h1>
                        <div class="container">
                        <div class="col-md-11.5 text-center">
                        <a href="dealers.xml" class="btn btn-light" style="margin-left: 20px;">A-Z</a>
                         
                         <a href="dealersD.xml" class="btn btn-light" style="margin-left: 20px;">Z-A</a>
                        
                        </div>
                       
                        <table class="table table-light" style="margin-top: 50px; font-size: 30px">
                         
                            <thead align="center">
                                <tr>
                                    <th style="border: 1px solid grey;">Nazwa</th>
                                    <th style="border: 1px solid grey;">Miasto</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="dealers/dealer">
                                <xsl:sort select="name" order="descending"/>
                                    <tr align="center">
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="name"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="city"/>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>    
                        </table>
                        
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>