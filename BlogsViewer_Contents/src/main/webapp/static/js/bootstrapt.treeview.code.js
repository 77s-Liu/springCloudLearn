Tree.prototype.buildTree = function (nodes, level) {

    if (!nodes) return;
    level += 1;

    var _this = this;
    $.each(nodes, function addNodes(id, node) {

        var treeItem = $(_this.template.item)
            .addClass('node-' + _this.elementId)
            .addClass(node.state.checked ? 'node-checked' : '')
            .addClass(node.state.disabled ? 'node-disabled': '')
            .addClass(node.state.selected ? 'node-selected' : '')
            .addClass(node.searchResult ? 'search-result' : '')
            .attr('data-nodeid', node.nodeId)
            .attr('style', _this.buildStyleOverride(node));

        // Add indent/spacer to mimic tree structure
        for (var i = 0; i < (level - 1); i++) {
            treeItem.append(_this.template.indent);
        }

        // Add expand, collapse or empty spacer icons
        var classList = [];
        if (node.nodes) {
            classList.push('expand-icon');
            if (node.state.expanded) {
                classList.push(_this.options.collapseIcon);
            }
            else {
                classList.push(_this.options.expandIcon);
            }
        }
        else {
            classList.push(_this.options.emptyIcon);
        }

        treeItem
            .append($(_this.template.icon)
                .addClass(classList.join(' '))
            );


        // Add node icon
        if (_this.options.showIcon) {

            var classList = ['node-icon'];

            classList.push(node.icon || _this.options.nodeIcon);
            if (node.state.selected) {
                classList.pop();
                classList.push(node.selectedIcon || _this.options.selectedIcon ||
                    node.icon || _this.options.nodeIcon);
            }

            treeItem
                .append($(_this.template.icon)
                    .addClass(classList.join(' '))
                );
        }

        // Add check / unchecked icon
        if (_this.options.showCheckbox) {

            var classList = ['check-icon'];
            if (node.state.checked) {
                classList.push(_this.options.checkedIcon);
            }
            else {
                classList.push(_this.options.uncheckedIcon);
            }

            treeItem
                .append($(_this.template.icon)
                    .addClass(classList.join(' '))
                );
        }

        // Add text
        if (_this.options.enableLinks) {
            // Add hyperlink
            treeItem
                .append($(_this.template.link)
                    .attr('href', node.href)
                    .append(node.text)
                );
        }
        else {
            // otherwise just text
            treeItem
                .append(node.text);
        }
//-----在这返回了
        // Add tags as badges
        if (_this.options.showTags && node.tags) {
            $.each(node.tags, function addTag(id, tag) {
                treeItem
                    .append($(_this.template.badge)
                        .append(tag)
                    );
            });
        }

        // Add item to the tree
        _this.$wrapper.append(treeItem);

        // Recursively add child ndoes
        if (node.nodes && node.state.expanded && !node.state.disabled) {
            return _this.buildTree(node.nodes, level);
        }
    });
};

// Define any node level style override for
// 1. selectedNode
// 2. node|data assigned color overrides
Tree.prototype.buildStyleOverride = function (node) {

    if (node.state.disabled) return '';

    var color = node.color;
    var backColor = node.backColor;

    if (this.options.highlightSelected && node.state.selected) {
        if (this.options.selectedColor) {
            color = this.options.selectedColor;
        }
        if (this.options.selectedBackColor) {
            backColor = this.options.selectedBackColor;
        }
    }

    if (this.options.highlightSearchResults && node.searchResult && !node.state.disabled) {
        if (this.options.searchResultColor) {
            color = this.options.searchResultColor;
        }
        if (this.options.searchResultBackColor) {
            backColor = this.options.searchResultBackColor;
        }
    }

    return 'color:' + color +
        ';background-color:' + backColor + ';';
};