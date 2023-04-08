
IMask(document.getElementById('telefone'), {
    mask: '(00) 00000-0000'
});


IMask(document.getElementById('cpf'), {
    mask: '000.000.000-00'
});

let emailMask = IMask(document.getElementById('email'), {
    mask: 'w@w.w',
    blocks: {
        w: { mask: /\w*/g }  // but probably should be different for each part...
    }
});


// IMask(document.getElementById('endereco'), {
//     mask: '00000-000'
// });

