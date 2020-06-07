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
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    
                        <h1 style="text-align: center;">Samochody</h1>
                        
                        <div class="col-md-11.5 text-center">
                        <a href="cars.xml" class="btn btn-light" style="margin-left: 20px;">A-Z</a>
                         
                         <a href="carsD.xml" class="btn btn-light" style="margin-left: 20px;">Z-A</a>
                        
                        </div>

                        <table class="table table-light" style="margin-top: 30px; margin-left: -20%; font-size: 30px">
                            <thead align="center">
                                <tr>
                                    <th style="border: 1px solid grey;">Marka</th>
                                
                                
                                    <th style="border: 1px solid grey;">Model</th>
                                
                                
                                    <th style="border: 1px solid grey;">Typ</th>
                               
                                    <th style="border: 1px solid grey;">Pojemność</th>
                                
                                    <th style="border: 1px solid grey;">Silnik</th>
                                
                                    <th style="border: 1px solid grey;">Skrzynia biegów</th>
                                
                                    <th style="border: 1px solid grey;">Rocznik</th>
                                
                                    <th style="border: 1px solid grey;">Uszkodzony</th>
                               
                                    <th style="border: 1px solid grey;">Kolor</th>
                                
                                    <th style="border: 1px solid grey;">Cena</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="cars/car">
                                <xsl:sort select="brand" order="descending"/>
                                    <tr align="center">
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="brand"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="model"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="type"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="capacity"/> L
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="engine"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="transmission"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="date"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="damaged"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="color"/>
                                        </td>
                                        <td style="border: 1px solid grey;">
                                            <xsl:value-of select="price"/> PLN
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