# How Inhertiance work here


```

```java
// Inheritance
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_typ", discriminatorType = DiscriminatorType.INTEGER)
// this annotation for reference wise hirarachy  10, 20 ,30... soon
@DiscriminatorValue("20")
// This annotation creates tables for models, mergging into one table

```

<pre class="code-fence" md-src-pos="371..771"><div class="code-fence-highlighter-copy-button" data-fence-content="VXNlcgoKCiAgIFRhICAgICAgICBNZW50b3IgICAgIEluc3RydWN0b3IKCi8vIFVzZXIgaXMgdGhlIFBhcmVudAovLyBUYSBtZW50b3IgYW5kIEluc3RydWN0b3IgdGhlc2UgYWxsIGFyZSBjaGlsZCB0byBVc2VyCi8vIEFib3ZlIGFubm90YXRpb24gY3JlYXRlIHRhYmxlcywgQWxsIGF0dHJpYnV0ZXMgaW5oZXJpdGVkIHRvIGNoaWxkIG1vZGxlIHRhYmxlcwovLyBlYWNoIGNoaWxkIHRhYmxlIGNvbnRhaW5zIHVzZXIgY2xhc3MgYXR0cmlidXRzIGFuZCBjaGlsZCBjbGFzcyBpdHNlbGYgYXR0cmlidXRzIAovLyBmaW5hbGx5IGNyZWF0ZWQgYWxsIHRhYmxlcywgZWFjaCBtb2RlbCBoYXZlIG9uZSB0YWJsZSB0b3RhbCA0IHRhYmxlIHdpbGwgY3JlYXRlZA=="><img class="code-fence-highlighter-copy-button-icon" data-original-src="src/main/java/org/api/productcatalogservice/inheritance/Joined" src="http://localhost:63342/markdownPreview/887208705/src/main/java/org/api/productcatalogservice/inheritance/Joined?_ijt=s5bsi3qmk3jpfql4o0g6d8n9v9"/><span class="tooltiptext"></span></div><code class="language-mindmap" md-src-pos="371..771"><span md-src-pos="371..382"></span><span md-src-pos="382..402">               User
</span><span md-src-pos="402..403">
</span><span md-src-pos="403..404">
</span><span md-src-pos="404..439">   Ta        Mentor     Instructor
</span><span md-src-pos="439..440">
</span><span md-src-pos="440..462">// User is the Parent
</span><span md-src-pos="462..518">// Ta mentor and Instructor these all are child to User
</span><span md-src-pos="518..600">// Above annotation create tables, All attributes inherited to child modle tables
</span><span md-src-pos="600..684">// each child table contains user class attributs and child class itself attributs 
</span><span md-src-pos="684..768">// finally created all tables, each model have one table total 4 table will created</span></code></pre>
