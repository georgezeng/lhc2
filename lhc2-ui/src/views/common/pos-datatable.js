export default {
    cols(startIndex, length, colTitle, fieldName, dataTxt, tmPos) {
        const cols = [
            {
                title: '特码',
                width: 60,
                render(h, params) {
                    if (!tmPos) {
                        return h('span', {}, `${params.row.num} (位${params.row.pos})`);
                    } else {
                        return h('span', {}, `${params.row.num} (${tmPos(params.row)})`);
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
                    if (data == 0) {
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
            let width = 60;
            if (dataTxt) {
                width = 80;
            }
            if (i < length - 1) {
                col.width = width;
            } else {
                col.minWidth = width;
            }
            cols.push(col);
        }
        return cols;
    },

    swData(index, row) {
        const data = row[`sw${index}`];
        const pos = row[`sw${index}Pos`];
        return `${data} (位${pos})`
    }
}
