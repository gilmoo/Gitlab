import { KwetterFrontPage } from './app.po';

describe('kwetter-front App', function() {
  let page: KwetterFrontPage;

  beforeEach(() => {
    page = new KwetterFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
