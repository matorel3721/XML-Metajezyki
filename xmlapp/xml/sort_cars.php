<?php
if($_SERVER['REQUEST_METHOD'] == "POST" and isset($_POST['asc'])){
        asc();
}
if($_SERVER['REQUEST_METHOD'] == "POST" and isset($_POST['desc'])){
        desc();
}

    function asc(){
        
        $XML = new DOMDocument();
        $XML->load('cars.xml');

        $xslDoc = new DOMDocument();
        $xslDoc->load('cars.xsl');

        $xsl = new XSLTProcessor();
        $xsl->importStyleSheet( $xslDoc );
        $xsl->setParameter( '', 'sortedBy', 'brand' );
        $xsl->setParameter( '', 'sort', 'ascending' );

        print $xsl->transformToXML($XML);
    }



    function desc(){

        $XML = new DOMDocument();
        $XML->load('cars.xml');

        $xslDoc = new DOMDocument();
        $xslDoc->load('cars.xsl');

        $xsl = new XSLTProcessor();
        $xsl->importStyleSheet( $xslDoc );
        $xsl->setParameter( '', 'sortedBy', 'brand' );
        $xsl->setParameter( '', 'sort', 'descending' );

        print $xsl->transformToXML($XML);
    }
?>