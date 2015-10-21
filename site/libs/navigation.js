function enableNavigation(source, target) {
    var link = document.querySelector('link[id="' + source + '"]');

    var template = link.import.querySelector('template');
    var clone = document.importNode(template.content, true);

    document.querySelector('#' + target).appendChild(clone);

}
