export default {
    cols(startIndex, length, colTitle, fieldName, dataTxt, tmPos, customWidth, tmWidth) {
        customWidth = customWidth ? customWidth : 80;
        tmWidth = tmWidth ? tmWidth : 80;
        const cols = [
            {
                title: '特码',
                width: tmWidth,
                render(h, params) {
                    if (!tmPos) {
                        if(params.row.pos != null) {
                            return h('span', {}, `${params.row.num} (位${params.row.pos})`);
                        } else {
                            return h('span', {}, '');
                        }
                    } else {
                        let posTxt = tmPos(params.row);
                        posTxt = posTxt ? "(" + posTxt + ")" : '';
                        return h('span', {}, `${params.row.num} ${posTxt}`);
                    }
                }
            }
        ];
        for (let i = startIndex; i < length; i++) {
            const col = {
                title: `${colTitle(i)}`,
                render(h, params) {
                    const style = {};
                    style['padding'] = '10px';
                    const data = params.row[`${fieldName(i)}`];
                    if (data != null && data == 0) {
                        style['background-color'] = 'red';
                        style['color'] = 'white';
                        style['font-weight'] = 'bold';
                    }
                    if (!dataTxt) {
                        return h('span', {style}, data);
                    } else {
                        return h('span', {style}, dataTxt(i, params.row));
                    }
                }
            };
            let width = customWidth;
            if (dataTxt) {
                width = customWidth + 20;
            }
            col.width = width;
            cols.push(col);
        }
        cols.push({
            title: '遗值和',
            width: 80,
            key: 'totalColsYz'
        })
        cols.push({
            title: '倒1-倒5遗值和',
            width: 80,
            key: 'rcolsYz'
        })
        cols.push({
            title: '最大遗值',
            width: 80,
            key: 'maxColYz'
        })
        cols.push({
            title: ''
        })
        return cols;
    },

    swData(index, row) {
        const data = row[`w${index}`];
        const pos = row[`w${index}Pos`];
        return `${data} (位${pos})`
    }
}
