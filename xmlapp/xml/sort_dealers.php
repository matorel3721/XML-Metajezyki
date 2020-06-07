<?php
if($_SERVER['REQUEST_METHOD'] == "POST" and isset($_POST['asc'])){
        asc();
}
if($_SERVER['REQUEST_METHOD'] == "POST" and isset($_POST['desc'])){
        desc();
}

    function asc(){
        
        $XML = new DOMDocument();
        $XML->load('dealers.xml');

        $xslDoc = new DOMDocument();
        $xslDoc->load('dealers.xsl');

        $xsl = new XSLTProcessor();
        $xsl->importStyleSheet( $xslDoc );
        $xsl->setParameter( '', 'sortedBy', 'name' );
        $xsl->setParameter( '', 'sort', 'ascending' );

        print $xsl->transformToXML($XML);
    }



    function desc(){

        $XML = new DOMDocument();
        $XML->load('dealers.xml');

        $xslDoc = new DOMDocument();
        $xslDoc->load('dealers.xsl');

        $xsl = new XSLTProcessor();
        $xsl->importStyleSheet( $xslDoc );
        $xsl->setParameter( '', 'sortedBy', 'name' );
        $xsl->setParameter( '', 'sort', 'descending' );

        print $xsl->transformToXML($XML);
    }
?>